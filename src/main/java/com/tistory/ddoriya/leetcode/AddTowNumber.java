/*
 * @(#) AddTowNumber.java 2021. 06. 08.
 */
package com.tistory.ddoriya.leetcode;

/**
 * @author 이상준
 */
public class AddTowNumber {
	/*
	두 개의 음수가 아닌 정수를 나타내는 비어 있지 않은 연결 리스트가 주어진다. 자릿수는 역순으로 저장되며, 각각의 노드는 한 자릿수를 포함하고 있다.
	두 숫자를 추가하고 합계를 링크된 목록으로 반환한다.
	0이라는 숫자 자체를 제외하고 두 숫자에 선행 0이 포함되어 있지 않다고 가정할 수 있다.

	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.

	Input: l1 = [0], l2 = [0]
	Output: [0]

	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]

	*/
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode();
		ListNode nextNode = resultNode;

		int temp = 0;
		while (l1 != null || l2 != null) {
			int resultValue = temp;

			if (l1 != null) {
				resultValue += l1.val;
			}

			if (l2 != null) {
				resultValue += l2.val;
			}

			temp = resultValue > 9 ? 1 : 0;

			ListNode subNode = new ListNode(resultValue % 10);
			nextNode.next = subNode;
			nextNode = subNode;

			if (l1 != null) {
				l1 = l1.next == null ? null : l1.next;
			}

			if (l2 != null) {
				l2 = l2.next == null ? null : l2.next;
			}
		}

		if (temp == 1) {
			ListNode subNode = new ListNode(temp);
			nextNode.next = subNode;
		}

		return resultNode.next;
	}


	public void print() {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//		System.out.println(l1);
//		System.out.println(l2);
//		addTwoNumbers(l1, l2);

		ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

		addTwoNumbers(l3, l4);
	}

	public static void main(String[] args) {
		new AddTowNumber().print();
	}
}
