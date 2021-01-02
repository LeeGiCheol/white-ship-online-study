package com.whiteship.homework.linkedlist;

public class LinkedList {

    ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void add(int value) {
        ListNode node = new ListNode(value);

        if (head == null) {
            head = node;
            return;
        }

        ListNode crnt = head;

        while (crnt.getNext() != null) {
            crnt = crnt.getNext();
        }

        crnt.setNext(node);
    }

    public void add(int value, int position) {
        ListNode node = new ListNode(value);

        if (head == null && position != 0) {
            System.out.println("리스트의 앞쪽부터 채워주세요");
            return;
        }

        if (head == null) {
            head = node;
            return;
        }

        ListNode crnt = head;
        ListNode prev = head;

        while (position-- > 0) {
            if (crnt == null && position > 0) {
                System.out.println("리스트의 앞쪽부터 채워주세요");
                return;
            }
            prev = crnt;
            crnt = crnt.getNext();
        }

        prev.setNext(node);
        crnt = prev;
    }


    public ListNode add(ListNode head, int value) {
        ListNode node = new ListNode(value);

        if (head == null) {
            head = node;
            return head;
        }

        if (head.getNext() == null) {
            head.setNext(node);
            return head;
        }

        ListNode crnt = head;

        while (crnt.getNext() != null) {
            crnt = crnt.getNext();
        }

        crnt.setNext(node);

        return head;
    }

    public void remove() {
        if (head == null) {
            return;
        }

        ListNode prev = head;
        ListNode node = head;

        while (node.getNext() != null) {
            prev = node;
            node = node.getNext();
        }

        prev.setNext(null);
    }

    public void remove(int position) {
        ListNode node = head;
        ListNode prev = node;

        if (position == 0) {
            head = head.getNext();
            return;
        }

        while (position-- > 0) {
            if(node.getNext() == null) {
                System.out.println("해당 인덱스에 노드가 없습니다.");
                return;
            }

            prev = node;
            node = node.getNext();
        }

        prev.setNext(node.getNext());
    }


    public ListNode remove(ListNode head, int position) {
        ListNode node = head;
        ListNode prev = node;

        if (position == 0) {
            head = head.getNext();
            return head;
        }

        while (position-- > 0) {
            if(node.getNext() == null) {
                System.out.println("해당 인덱스에 노드가 없습니다.");
                return null;
            }

            prev = node;
            node = node.getNext();
        }

        prev.setNext(node.getNext());

        return prev;
    }


    public int get(int index) {
        ListNode node = head;

        while (index-- > 0) {
            if (node.getNext() == null && index > 0) {
                throw new IndexOutOfBoundsException();
            }

            if (node.getNext() != null) {
                node = node.getNext();
            }
        }

        return node.getValue();
    }


    public boolean contains(ListNode head, ListNode nodeToCheck) {
        while (head != null) {
            if (head.getValue() == nodeToCheck.getValue()) {
                return true;
            }
            head = head.getNext();
        }

        System.out.println("리스트에 존재하지 않는 노드입니다.");
        return false;
    }

    public void travel() {
        if (head == null) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }

        ListNode node = head;
        while (node.getNext() != null) {
            System.out.print(node.getValue() + ", ");
            node = node.getNext();
        }
        System.out.println(node.getValue());

    }
}
