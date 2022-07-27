package com.pandy.algorithm.offer.question;


import com.pandy.algorithm.offer.common.TreeNode;

import java.util.*;

public class Test {
    ArrayList<TreeNode> treenode = new ArrayList<>();

    /**
     * 第k大的元素
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kmax(int[] arr, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i : arr) {
            if (min.size() < k) {
                min.add(i);
            } else {
                if (min.peek() > i) {
                    min.remove();
                    min.add(i);
                }
            }
        }
        return min.peek();
    }

    /**
     * 第k小的元素
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kmin(int[] arr, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> (y - x));
        for (int i : arr) {
            if (max.size() < k) {
                max.add(i);
            } else {
                if (max.peek() < i) {
                    max.remove();
                    max.add(i);
                }
            }
        }
        return max.peek();
    }

    /**
     * 数组中和最大的子串
     *
     * @param arr
     * @return
     */
    public static int maxSub(int[] arr) {
        int sum = 0;
        int result = arr[0];
        for (int i : arr) {
            if (i < 0) {
                sum = i;
            } else {
                sum += i;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    /**
     * 数组中元素 打平后 组成的最小数字
     *
     * @param arr
     * @return
     */
    public static String printMinNum(int[] arr) {
        int len = arr.length;
        // 字符数组
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        // 重写排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o1 + o1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    /**
     * 获取第一个公共节点
     *
     * @param phead1
     * @param phead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode phead1, ListNode phead2) {
        ListNode p1 = phead1;
        ListNode p2 = phead2;
        while (p1 != p2) {
            p1 = (p1 != null ? p1.next : phead2);
            p2 = (p2 != null ? p2.next : phead1);
        }
        return p1;
    }

    /**
     * 获取数组中元素的数量
     *
     * @param arr
     * @param k
     * @return
     */
    public int getNumOfk(int[] arr, int k) {
        int res = 0;
        int mid = arr.length / 2;
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            if (arr[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }

        if (k < arr[mid]) {
            res += getNumOfk(Arrays.copyOfRange(arr, 0, mid), k);
        } else if (k > arr[mid]) {
            res += getNumOfk(Arrays.copyOfRange(arr, mid, arr.length), k);
        } else {
            for (int i = mid; i < arr.length; i++) {
                if (arr[i] == k) {
                    res++;
                } else {
                    break;
                }
            }

            for (int i = mid - 1; i >= 0; i--) {
                if (arr[i] == k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 判断是否为平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanceTree(TreeNode root) {
        if (root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int diff = left - right;
        return diff >= -1 && diff <= 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        int leftNode = getDepth(root.left);
        int rightNode = getDepth(root.right);
        depth = Math.max(leftNode, rightNode);
        return depth + 1;
    }

    /**
     * 升序数组查找俩数字和为sum 若多个取乘积最大 明显成绩最大的是左右遍历第一次遇见的
     *
     * @param arr
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumberWithSum(int[] arr, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null) return list;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int s = arr[left] + arr[right];
            if (s == sum) {
                list.add(arr[left]);
                list.add(arr[right]);
                return list;
            } else {
                if (s > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    /**
     * 反转字符串
     *
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.trim().length() == 0) return str;

        StringBuilder stringBuilder = new StringBuilder();
        String re = reverse(str);
        String[] s = re.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            stringBuilder.append(reverse(s[i]) + " ");
        }
        stringBuilder.append(reverse(s[s.length - 1]));
        return String.valueOf(stringBuilder);
    }

    private String reverse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return String.valueOf(stringBuilder);
    }

    /**
     * 左移k位输出
     *
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString(String str, int n) {
        String s1 = reverse(str.substring(0, n));
        String s2 = reverse(str.substring(n));
        return reverse(s2) + reverse(s1);
    }

    /**
     * 约瑟夫环
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int bt = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    /**
     * 求两数之和
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    /**
     * 二叉树的第k大的节点
     *
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode kth(TreeNode pRoot, int k) {
        inOrder(pRoot);
        if (treenode.size() < 1 || k < 1 || k > treenode.size()) return null;
        return treenode.get(k - 1);
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            treenode.add(node);
            inOrder(node.right);
        }
    }
}
