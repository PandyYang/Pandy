package com.pandy.algorithm.huawei;

import java.util.*;

public class Solution {

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        // 用来记录当前节点的上一个节点
        ListNode pre = null;
        // 用来记录当前节点的下一个节点
        ListNode next = null;
        // 需要pre next 的作用是想让当前节点pre->head->next1->next2  => pre<-head next1->next2
        // next防止next1节点断开
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head =next;
        }
        return pre;
    }

    /**
     * 设计LRU缓存结构
     */
    public int[] lRU(int[][] operators, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int[] operator : operators) {
            int key = operator[1];
            switch (operator[0]) {
                // 表示需要插入元素
                case 1:
                    int value = operator[2];
                    // 插入元素
                    if (map.size() < k) {
                        map.put(key, value);
                    } else {
                        Iterator<Integer> iterator = map.keySet().iterator();
                        map.remove(iterator.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    // 获取已存在的元素
                    if (map.containsKey(key)) {
                        int val = map.get(key);
                        list.add(val);
                        map.remove(key);
                        map.put(key, val);
                    } else {
                        list.add(-1);
                    }
                    break;
                default:
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int val: list) {
            res[i++] = val;
        }
        return res;
    }

    /**
     * 打印二叉树的前中后序遍历
     * @param root
     * @return
     */

    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        if (root == null) return new int[][]{{}};
        List<List<Integer>> ans = new ArrayList<>();
        preOrder(root);
        inOrder(root);
        postOrder(root);
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }

    public static int findKth(int[] a, int n, int k) {
        return find(a, 0, n-1, k);
    }

    private static int find(int[] a, int low, int high, int k) {
        int pivot = partition(a, low, high);
        if (pivot + 1 < k) {
            return find(a, pivot + 1, high, k);
        } else if (pivot + 1 > k) {
            return find(a, low, pivot - 1, k);
        } else {
            return a[pivot];
        }
    }

    // 数组分为左大右小的两部分
    private static int partition(int[] a, int low, int high) {
        int pivotValue = a[low];
        while (low < high) {
            while (low < high && a[high] <= pivotValue) {
                --high;
                a[low] = a[high];
            }
            while (low < high && a[low] >= pivotValue) {
                ++low;
                a[high] = a[low];
            }
            a[low] = pivotValue;
        }
        // 返回数组的中轴位置
        return low;
    }

    /**
     * 使用小顶堆实现
     * @param
     */
    public static int Kth2(int[] a, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i : a) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (i > queue.peek()) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        return queue.peek();
    }

    public static int findKth3(int[] a, int n, int k) {
        quickSort(a, 0, a.length-1);
        return a[n-1+k+1];
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }

        int i = low;
        int j = high;

        int temp = a[low];

        while (i < j) {
            while (i<j && temp <= a[j]) {
                j--;
            }
            while (i < j && temp >= a[i]) {
                i++;
            }

            if (i < j) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }

        a[low] = a[j];
        a[i] = temp;

        quickSort(a, low, j-1);
        quickSort(a, j+1, high);
    }

    /**
     * 求两数之和
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int res = target - numbers[i];
            for (int i1 = i+1; i1 < numbers.length; i1++) {
                if (numbers[i1] == res) {
                    result[0] = i+1;
                    result[1] = i1+1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 快速排序 依稀觉得几大排序很重要
     */
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) return;
        i = low;
        j = hight;
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] < index)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        sort(a, low, i-1);
        sort(a, i+1, hight);
    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length-1);
    }

    /**
     * 合并有序链表
     * 递归方法
     * @param
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode l = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        while (l1 != null || l2 != null) {
            if (l1.val > l2.val) {
                l = l2;
                l.next = mergeTwoLists(l1, l2.next);
            } else {
                l = l1;
                l.next = mergeTwoLists(l1.next, l2);
            }
        }
        return l;
    }

    /**
     * 合并有序链表
     * 非递归方式
     */
    public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoLists2 (ListNode l1, ListNode l2) {
        // write code here
        ListNode head = new ListNode(0);
        ListNode l = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 != null) {
            l.next = l1;
        }

        if(l2 != null) {
            l.next = l2;
        }
        return l.next;
    }

    public static ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(0);//问题2
        ListNode p = head;
        while(l1!=null&&l2!=null){//问题3和4
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2= l2.next;
            }
            p=p.next;
        }
        if(l1!=null){//问题1和5
            p.next=l1;
        }
        if(l2!=null){
            p.next=l2;
        }
        return head.next;
    }


    /**
     * 青蛙跳台阶
     */
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target -1 ) + jumpFloor(target - 2);
    }

    /**
     * 子数组的最大累加和问题
     */
    public int maxSumOfSubarray(int[] array) {
        if (array == null || array.length == 0) return -1;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    /**
     * 最长无重复子数组
     * 双指针
     * @param arr
     * @return
     */
    public static int maxLength (int[] arr) {
        // write code here
        LinkedList list = new LinkedList();
        int p = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                int j = list.indexOf(arr[i]);
                // 将数组之前的全部删除
                while (j -- >= 0) {
                    list.removeFirst();
                }
            }
            list.add(arr[i]);
            ans = Math.max(ans, list.size());
        }
        return ans;
    }

    public int maxLength2 (int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int p=0, ans=0;
        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])){
                int j=list.indexOf(arr[i]);
                while (j-->=0){
                    list.removeFirst();
                }
            }
            list.add(arr[i]);
            ans=Math.max(ans,list.size());
        }
        return ans;
    }

    public int lengthOfLongestSubString(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        if (n < 2) return n;
        int res = 0;
        HashSet set = new HashSet();
        int i = 0, j = 0;
        while (j < n) {
            if (!set.contains(a[j])) {
                set.add(a[j]);
                j++;
            } else {
                set.remove(a[i]);
                i++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    /**
     * 括号序列
     */
    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<Character>();
        //使用foreach循环
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(isValid("{[]}"));
        maxLength(new int[]{1, 2, 3, 2, 1});


//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        //System.out.println(Kth2(new int[]{1, 3, 5, 2, 2}, 5, 3));
        //System.out.println(findKth(new int[]{1, 3, 5, 2, 2}, 5, 3));

//        for (int i : twoSum(new int[]{0,4,3,0}, 0)) {
//            System.out.println(i);
//        }

        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a);
        System.out.println(Arrays.toString(a));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        mergeTwoLists2(l1, l2);
        mergeTwoLists4(l1, l2);
    }
}
