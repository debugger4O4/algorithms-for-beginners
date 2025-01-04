import java.util.*;

public class ID3 {

    // Алгоритм
    public static Map<String, Object> id3(List<Map<String, String>> examples, String targetAttribute, Set<String> attributes, Map<String, List<String>> attributeValues) {

        // Создаем корень дерева
        Map<String, Object> dt = new HashMap<>();

        // Проверяем, все ли примеры имеют одинаковое значение целевого атрибута
        if (checkAllSame(examples, targetAttribute)) {
            String value = examples.get(0).get(targetAttribute);
            dt.put(targetAttribute, value);
            return dt;
        }

        // Если нет оставшихся атрибутов, возвращаем наиболее распространенный класс
        if (isSetEmpty(attributes)) {
            String mostCommonValue = findMostCommon(examples, targetAttribute);
            dt.put(targetAttribute, mostCommonValue);
            return dt;
        }

        // Находим лучший классификатор среди оставшихся атрибутов
        String bestClassifier = bestClassifier(examples, attributes, targetAttribute);

        // Добавляем тестовый атрибут к дереву
        dt.put("test_attribute", bestClassifier);

        // Для каждого возможного значения лучшего классификатора создаем поддерево
        for (String value : attributeValues.get(bestClassifier)) {
            List<Map<String, String>> examplesSubset = filterExamples(examples, bestClassifier, value);

            // Если примеров с данным значением нет, добавляем листовой узел с наиболее распространенным классом
            if (isSetEmpty(examplesSubset)) {
                String mostCommonValue = findMostCommon(examples, targetAttribute);
                Map<String, Object> child = new HashMap<>();
                child.put(targetAttribute, mostCommonValue);
                child.put("branch", value);
                addChild(dt, child);
            } else { // Иначе рекурсивно строим поддерево
                Set<String> offspringAttributes = removeFromSet(attributes, bestClassifier);
                Map<String, Object> child = id3(examplesSubset, targetAttribute, offspringAttributes, attributeValues);
                child.put("branch", value);
                addChild(dt, child);
            }
        }

        return dt;
    }

    private static boolean checkAllSame(List<Map<String, String>> examples, String targetAttribute) {
        String firstValue = examples.get(0).get(targetAttribute);
        for (int i = 1; i < examples.size(); i++) {
            if (!firstValue.equals(examples.get(i).get(targetAttribute))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSetEmpty(Set<String> attributes) {
        return attributes.isEmpty();
    }

    private static boolean isSetEmpty( List<Map<String, String>> attributes) {
        return attributes.isEmpty();
    }

    private static String findMostCommon(List<Map<String, String>> examples, String targetAttribute) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Map<String, String> example : examples) {
            String value = example.get(targetAttribute);
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        int maxCount = 0;
        String mostCommonValue = "";
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonValue = entry.getKey();
            }
        }
        return mostCommonValue;
    }

    private static String bestClassifier(List<Map<String, String>> examples, Set<String> attributes, String targetAttribute) {
        double maxGain = Double.NEGATIVE_INFINITY;
        String bestClassifier = null;
        for (String attribute : attributes) {
            double gain = calculateInformationGain(examples, attribute, targetAttribute);
            if (gain > maxGain) {
                maxGain = gain;
                bestClassifier = attribute;
            }
        }
        return bestClassifier;
    }

    private static double calculateInformationGain(List<Map<String, String>> examples, String attribute, String targetAttribute) {
        double entropyBeforeSplit = calculateEntropy(examples, targetAttribute);
        double weightedSumOfEntropiesAfterSplit = 0.0;
        Map<String, List<Map<String, String>>> subsetsByAttributeValue = groupExamplesByAttributeValue(examples, attribute);
        for (Map.Entry<String, List<Map<String, String>>> entry : subsetsByAttributeValue.entrySet()) {
            double proportion = (double) entry.getValue().size() / examples.size();
            double entropyAfterSplit = calculateEntropy(entry.getValue(), targetAttribute);
            weightedSumOfEntropiesAfterSplit += proportion * entropyAfterSplit;
        }
        return entropyBeforeSplit - weightedSumOfEntropiesAfterSplit;
    }

    private static double calculateEntropy(List<Map<String, String>> examples, String targetAttribute) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Map<String, String> example : examples) {
            String value = example.get(targetAttribute);
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        double entropy = 0.0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            double probability = (double) entry.getValue() / examples.size();
            entropy -= probability * Math.log(probability) / Math.log(2);
        }
        return entropy;
    }

    private static Map<String, List<Map<String, String>>> groupExamplesByAttributeValue(List<Map<String, String>> examples, String attribute) {
        Map<String, List<Map<String, String>>> result = new HashMap<>();
        for (Map<String, String> example : examples) {
            String value = example.get(attribute);
            if (!result.containsKey(value)) {
                result.put(value, new ArrayList<>());
            }
            result.get(value).add(example);
        }
        return result;
    }

    private static List<Map<String, String>> filterExamples(List<Map<String, String>> examples, String attribute, String value) {
        List<Map<String, String>> filteredExamples = new ArrayList<>();
        for (Map<String, String> example : examples) {
            if (example.get(attribute).equals(value)) {
                filteredExamples.add(example);
            }
        }
        return filteredExamples;
    }

    private static Set<String> removeFromSet(Set<String> attributes, String attributeToRemove) {
        Set<String> result = new HashSet<>(attributes);
        result.remove(attributeToRemove);
        return result;
    }

    private static void addChild(Map<String, Object> parent, Map<String, Object> child) {
        if (!parent.containsKey("children")) {
            parent.put("children", new ArrayList<>());
        }
        ((ArrayList<Object>) parent.get("children")).add(child);
    }
}