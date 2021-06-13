package litooong.com.github.medium;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 */
public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        // 1. 将体重按从小到大排序
        Arrays.sort(people);
        // 2. 双端指针
        int i = 0;
        int j = people.length - 1;
        while (j >= i) {
            // 如果最大体重的人与最小体重的人体重相加不超过 limit，则俩人凑一艘船
            if (people[i] + people[j] <= limit) {
                i++;
            }
            // 如果超过了，小体重的 i 不动，体重大的一人一艘船
            boats += 1;
            j--;
        }
        return boats;
    }
}
