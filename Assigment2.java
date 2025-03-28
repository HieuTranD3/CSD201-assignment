package assigment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Book {
    String isbn;
    String title;
    String author;
    String yearOfPublication;
    String publisher;

    public Book(String isbn, String title, String author, String yearOfPublication, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author +
               ", Year: " + yearOfPublication + ", Publisher: " + publisher;
    }
}

class AVLNode {
    Book book;
    AVLNode left, right;
    int height;

    public AVLNode(Book book) {
        this.book = book;
        this.left = this.right = null;
        this.height = 1;
    }
}

class AVLTree {
    AVLNode root;

    public AVLTree() {
        root = null;
    }

    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void readAndInsertFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 5) {
                    try {
                        String isbn = values[0].trim();
                        String title = values[1].trim();
                        String author = values[2].trim();
                        String year = values[3].trim(); 
                        String publisher = values[4].trim();

                        Book book = new Book(isbn, title, author, year, publisher);
                        insert(book);
                    } catch (Exception e) {
                        System.err.println("Error reading data: " + e.getMessage());
                    }
                }
            }
        }
    }

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private AVLNode insertRec(AVLNode node, Book book) {
        if (node == null) {
            return new AVLNode(book);
        }

        if (book.isbn.compareTo(node.book.isbn) < 0) {
            node.left = insertRec(node.left, book);
        } else if (book.isbn.compareTo(node.book.isbn) > 0) {
            node.right = insertRec(node.right, book);
        } else {
            return node; 
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return rebalance(node);
    }

    private AVLNode rebalance(AVLNode node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public Book searchFirst() {
        AVLNode firstNode = findFirst(root);
        return (firstNode != null) ? firstNode.book : null;
    }

    private AVLNode findFirst(AVLNode node) {
        AVLNode current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    public void printAllBooks() {
        System.out.println("Books in AVL Tree (Sorted by ISBN):");
        printInOrder(root);
    }

    private void printInOrder(AVLNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.book);
            printInOrder(node.right);
        }
    }
}

public class Assigment2 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        String filePath = "books.csv";

        try {
            tree.readAndInsertFromCSV(filePath);

            Book firstBook = tree.searchFirst();
            if (firstBook != null) {
                System.out.println("First book in AVL tree: " + firstBook);
            } else {
                System.out.println("No books found in AVL tree.");
            }

            tree.printAllBooks();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
