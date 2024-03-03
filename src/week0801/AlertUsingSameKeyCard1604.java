package week0801;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertUsingSameKeyCard1604 {

}
/*
1.map存 map<String,List<Integer>>.
第一步把名字，时间转化成数字放到map里面。
2.对map进行便历
取每个map.entrySet中的Entry,entry.getValue为时间列表。
用size为3的滑动窗口，如果list.get(i)-list.get(i-2)的值<=60则把这个人家加到警告列表。
*/
class Solution {
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<Integer>> nameAndTimes = new HashMap<>();
		for (int i = 0; i < keyName.length; i++) {
			Integer time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60
					+ Integer.parseInt(keyTime[i].substring(3));

			nameAndTimes.computeIfAbsent(keyName[i], k -> new ArrayList<Integer>()).add(time);
		}
		List<String>warningList =new ArrayList<>();
		for (Map.Entry<String, List<Integer>> nameAndTime : nameAndTimes.entrySet()) {
			List<Integer> times = nameAndTime.getValue();
			for(int i=2; i<times.size();i++) {
				if(times.get(i)-times.get(i-2)<=60) {
					warningList.add(nameAndTime.getKey());
					break;
				}
			}

		}
		warningList.sort(Comparator.naturalOrder());
		return warningList;
	}
}