package com.example.bdkj_website.tools;

import java.util.*;

/**
 * <p>Title: BDCollectionUtils</p>
 * <p>Description: 集合工具类</p>
 * <p>Company: 成都邦道科技有限公司</p>
 *
 * @author zhanghw
 * @date 2020/3/26 4:17 PM
 */
public class BDCollectionUtils {

    // *****************************************************判空**********************************************

    /**
     * @param datas
     * @return true表示为空
     * @author Z.H.W
     * @Description:判断所给集合是否为空
     */
    public static <T> boolean isEmpty(Collection<T> datas) {
        return datas == null || datas.isEmpty();
    }

    /**
     * @param datas
     * @return true表示不为空
     * @author Z.H.W
     * @Description:判断所给集合是否为空
     */
    public static <T> boolean isNotEmpty(Collection<T> datas) {
        return !isEmpty(datas);
    }

    // *****************************************************分组**********************************************

    /**
     * @param datas
     * @param unitCount 代表每组的个数
     * @return 返回所有的组
     * @author Z.H.W
     * @Description:按个数分组
     */
    public static <T> List<List<T>> divider(Collection<T> datas, int unitCount) {
        List<List<T>> returnDatas = new ArrayList<List<T>>();
        List<T> unit = null;
        int counter = 0;
        for (T t : datas) {
            if (counter % unitCount == 0) {
                unit = new ArrayList<T>();
                returnDatas.add(unit);
            }
            unit.add(t);
            counter++;
        }
        return returnDatas;
    }


    /**
     * @param datas
     * @param c     是否为同一组的判断标准，相同的数据分为同一组
     * @return
     * @author Z.H.W
     * @Description:按条件分组
     */
    public static <T> List<List<T>> divider(Collection<T> datas, Comparator<? super T> c) {
        List<List<T>> result = new ArrayList<List<T>>();
        for (T t : datas) {
            boolean isSameGroup = false;
            for (int j = 0; j < result.size(); j++) {
                if (c.compare(t, result.get(j).get(0)) == 0) {
                    isSameGroup = true;
                    result.get(j).add(t);
                    break;
                }
            }
            if (!isSameGroup) {
                // 创建
                List<T> innerList = new ArrayList<T>();
                result.add(innerList);
                innerList.add(t);
            }
        }
        return result;
    }

    // *****************************************************拼接/并集**********************************************

    /**
     * @param datas
     * @return
     * @author Z.H.W
     * @Description:拼接集合
     */
    public static <T, K extends Collection<T>> List<T> contact(Collection<K> datas) {
        List<T> result = new ArrayList<>();
        for (K k : datas) {
            result.addAll(k);
        }
        return result;
    }

    /**
     * @param datas
     * @return
     * @author Z.H.W
     * @Description:拼接集合
     */
    public static <T, K extends Collection<T>> List<T> contact(K... datas) {
        return contact(Arrays.asList(datas));
    }

    // *****************************************************交集**********************************************

    /**
     * @param datas
     * @return
     * @author Z.H.W
     * @Description:集和类求交集
     */
    public static <T, K extends Collection<? extends T>> List<T> intersection(Collection<K> datas) {
        List<T> result = new ArrayList<>();
        Iterator<K> it = datas.iterator();
        if (it.hasNext()) {
            K copy = it.next();
            if (copy != null) {
                result = new ArrayList<>(copy);
                for (K k : datas) {
                    result.retainAll(k);
                }
            }
        }
        return result;
    }

    /**
     * @param datas
     * @return
     * @author Z.H.W
     * @Description:集和类求交集
     */
    public static <T, K extends Collection<? extends T>> List<T> intersection(K... datas) {
        return intersection(Arrays.asList(datas));
    }

    // *****************************************************差集**********************************************

    /**
     * @param a
     * @param b
     * @return A-B
     * @author Z.H.W
     * @Description:求差集
     */
    public static <T, K extends Collection<? extends T>> List<T> sub(K a, K b) {
        List<T> result = new ArrayList<>();
        if (a != null) {
            result = new ArrayList<>(a);
            result.removeAll(b);
        }
        return result;
    }

    // *****************************************************判重、查重、去重**********************************************

    /**
     * @param datas 需要判断的目标集合
     * @return
     * @author Z.H.W
     * @Description:判重，判断集合中的元素是否有重复元素
     */
    public static boolean isRepeatInCollection(Collection<?> datas) {
        if (datas == null) {// 为空则认为不含重复元素
            return false;
        }
        if (datas instanceof Set) {
            return false;
        }
        Set<?> noRepeatSet = new HashSet<>(datas);
        return !(datas.size() == noRepeatSet.size());
    }

    /**
     * @param datas
     * @return
     * @author Z.H.W
     * @Description:查重，找出集合中的重复数据
     */
    public static <T> List<T> findRepeat(Collection<T> datas) {
        if (datas instanceof Set) {
            return new ArrayList<>();
        }
        HashSet<T> set = new HashSet<T>();
        List<T> repeatEles = new ArrayList<T>();
        for (T t : datas) {
            if (set.contains(t)) {
                repeatEles.add(t);
            } else {
                set.add(t);
            }
        }
        return repeatEles;
    }

    public static <T> int findRepeatObjectSize(Collection<T> datas, T obj) {
        int count = 0;
        if (datas instanceof Set) {
            return count;
        }
        List<T> repeatEles = new ArrayList<T>();
        repeatEles.addAll(datas);
        for (int i = 0; i < repeatEles.size(); i++) {
            if (repeatEles.size() == 0) {
                break;
            }
            if (((T) repeatEles.get(i)).equals(obj)) {
                count++;
                repeatEles.remove(i);
                i--;
            }
        }
//        for (T t : datas) {
//            if (t.equals(obj)) {
//                count++;
//            }
//        }
        return count;
    }

    /**
     * @param datas
     * @return List<T> 以list形式返回结果
     * @author Z.H.W
     * @Description:去重，以并转化为List
     */
    public static <T> List<T> distinct(Collection<T> datas) {
        if (datas == null) {
            return new ArrayList<>();
        }
        Set<T> set = null;
        if (datas instanceof Set) {
            return new ArrayList<>(datas);
        } else {
            set = new HashSet<>(datas);
        }
        return new ArrayList<>(set);
    }

    // *****************************************************过滤**********************************************

    /**
     * @param datas     数据源
     * @param condition 过滤条件
     * @return 返回过滤后的集合
     * @author Z.H.W
     * @Description:过滤集合
     */
    public static <T> List<T> filter(Collection<T> datas, Filter<T> condition) {
        List<T> result = new ArrayList<>();
        if (condition != null) {
            for (T t : datas) {
                if (condition.pass(t)) {
                    result.add(t);
                }
            }
        } else {
            return new ArrayList<>(datas);
        }
        return result;
    }

    /**
     * 过滤器
     *
     * @param <T>
     * @author puyafeng
     */
    public interface Filter<T> {
        /**
         * 筛选是否通过
         *
         * @param t
         * @return true 表示通过
         */
        boolean pass(T t);
    }

    /**
     * 截取部分list
     * @param list 数据
     * @param start 开始索引
     * @param size  截取片段的大小
     * @param <T>
     * @return
     */
    public static <T> List<T> cutList(List<T> list,Integer start,Integer size){
        return list.subList(start,start+size);
    }

}
