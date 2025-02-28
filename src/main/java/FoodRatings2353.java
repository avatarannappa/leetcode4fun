import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2353. 设计食物评分系统.
 * medium
 *
 * @author avatarannappa
 * @version 2025/2/28
 */
public class FoodRatings2353 {

    public static class FoodRating {

        String food;
        int rating;
        String cuisine;
    }

    Map<String, PriorityQueue<FoodRating>> map = new HashMap<>();
    Map<String, FoodRating> foodCuisineMap = new HashMap<>();

    public FoodRatings2353(String[] foods, String[] cuisines, int[] ratings) {
        // 哈希表，堆
        for (int i = 0; i < foods.length; i++) {
            FoodRating foodRating = new FoodRating();
            foodRating.food = foods[i];
            foodRating.cuisine = cuisines[i];
            foodRating.rating = ratings[i];
            PriorityQueue<FoodRating> queue = map.getOrDefault(cuisines[i], new PriorityQueue<>((o1, o2) -> o2.rating - o1.rating == 0 ?
                    o1.food.compareTo(o2.food) : o2.rating - o1.rating));
            queue.add(foodRating);
            map.put(cuisines[i], queue);
            foodCuisineMap.put(foods[i], foodRating);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodRating foodRating = foodCuisineMap.get(food);
        FoodRating newFoodRating = new FoodRating();
        newFoodRating.food = food;
        newFoodRating.cuisine = foodRating.cuisine;
        newFoodRating.rating = newRating;
        PriorityQueue<FoodRating> queue = map.get(foodRating.cuisine);
        queue.remove(foodRating);
        queue.add(newFoodRating);
        map.put(foodRating.cuisine, queue);
        foodCuisineMap.put(food, newFoodRating);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodRating> queue = map.get(cuisine);
        return queue.peek().food;
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        // [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
    }

}
