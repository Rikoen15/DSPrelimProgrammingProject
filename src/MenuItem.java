import java.util.Scanner;

public class MenuItem<E> extends MySinglyLinkedList<E> {
    Node<E> current;
    String label;

    MenuItem(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        current = super.getHead();
        StringBuilder menu = new StringBuilder("[ ");
        do {
            menu.append(current.getData());
            if (current.getNext() != null) menu.append(", ");
            current = current.getNext();
        } while (current != null || getSize() == 1);
        menu.append(" ]");
        return menu.toString();
    }

    public Node<E> lookup(String data) {
        if (getSize() == 0) return null;
        Node<E> current = super.getHead();
        do {
            if (current.getData().equals(data)) return current;
            current = current.getNext();
        } while (current != null|| super.getSize() == 1);
        return null;
    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public void navigate() {
        System.out.println(this);
        String choice = getInput("Input");
        if (choice.equalsIgnoreCase("x")) return;
        current = lookup(choice);
        navigate();
    }

    @Override
    public void insert(E data) throws ListOverflowException {
        super.insert(data);
    }

    public Node<E> getCurrent() {
        return current;
    }

    public String getLabel() {
        return label;
    }
}
