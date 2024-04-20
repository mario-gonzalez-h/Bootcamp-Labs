package org.example;

public class Library {
    //Array
    private static Books[] inventory;

    // Constructor to initialize the library inventory with sample books
    public Library() {
        //inventory: Array of Book objects
        inventory = new Books[20];
        initializeInventory();
    }

    // Method to populate the library inventory with sample books
    private void initializeInventory() {
        inventory[0] = new Books(1, "To Kill a Mockingbird", "Harper Lee", "9780061120084");
        inventory[1] = new Books(2, "Head First Java", "Kathy Sierra, Bert Bates", "9780596009205");
        inventory[2] = new Books(3, "Effective Java", "Joshua Bloch", "9780134685991");
        inventory[3] = new Books(4, "Java: A Beginner's Guide", "Herbert Schildt", "9781260440225");
        inventory[4] = new Books(5, "Java Concurrency in Practice", "Brian Goetz et al.", "9780321349606");
        inventory[5] = new Books(6, "Clean Code", "Robert C. Martin", "9780132350884");
        inventory[6] = new Books(7, "Thinking in Java", "Bruce Eckel", "9780131872486");
        inventory[7] = new Books(8, "Java Generics and Collections", "Maurice Naftalin, Philip Wadler", "9780596527754");
        inventory[8] = new Books(9, "Java Performance: The Definitive Guide", "Scott Oaks", "9781449358457");
        inventory[9] = new Books(10, "Java 8 in Action", "Raoul-Gabriel Urma et al.", "9781617291999");
        inventory[10] = new Books(11, "Java: The Complete Reference", "Herbert Schildt", "9781260440232");
        inventory[11] = new Books(12, "Spring in Action", "Craig Walls", "9781617294945");
        inventory[12] = new Books(13, "Head First Design Patterns", "Eric Freeman, Elisabeth Robson", "9780596007126");
        inventory[13] = new Books(14, "Clean Architecture: A Craftsman's Guide to Software Structure and Design", "Robert C. Martin", "9780134494166");
        inventory[14] = new Books(15, "Effective Java, 2nd Edition", "Joshua Bloch", "9780321356680");
        inventory[15] = new Books(16, "Java Design Patterns: A Hands-On Experience with Real-World Examples", "Vaskaran Sarcar", "9781484240778");
        inventory[16] = new Books(17, "Java Puzzlers: Traps, Pitfalls, and Corner Cases", "Joshua Bloch, Neal Gafter", "9780321336781");
        inventory[17] = new Books(18, "Java Network Programming", "Elliotte Rusty Harold", "9781449357672");
        inventory[18] = new Books(19, "Java 9 Modularity: Patterns and Practices for Developing Maintainable Applications", "Sander Mak, Paul Bakker", "9781491954162");
        inventory[19] = new Books(20, "Murach's Java Programming", "Joel Murach", "9781943872077");

    }

    // Method to display available books in the inventory
    public static void showAvailableBooks() {
        System.out.println("Searching Available Books:\n " +
                "  ,-.       _,---._ __  / \\\n" +
                " /  )    .-'       `./ /   \\\n" +
                "(  (   ,'            `/    /|\n" +
                " \\  `-\"             \\'\\   / |\n" +
                "  `.              ,  \\ \\ /  |\n" +
                "   /`.          ,'-`----Y   |\n" +
                "  (            ;        |   '\n" +
                "  |  ,-.    ,-'         |  /\n" +
                "  |  | (   |            | /\n" +
                "  )  |  \\  `.___________|/\n" +
                "  `--'   `--'");
        for (Books book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book); // Print book details if it's available
            }
        }
                System.out.println(
                        "⠀      (\\ __ /)\n" +
                        "        (UwU)\n" +
                        "     ＿ノ ヽ ノ＼＿ \n" +
                        "  /　`/ ⌒Ｙ⌒ Ｙ　 \\\n" +
                        "( 　(三ヽ人　 /　　|\n" +
                        "|　ﾉ⌒＼ ￣￣ヽ　 ノ\n" +
                        "ヽ＿＿＿＞､＿＿／\n" +
                        "     | 王 ﾉ〈 \n" +
                        "    /ﾐ`ー―彡\\ \n" +
                        "   / ╰      ╯ \\\n" +
                "Books I Found!!");


    }

    // Method to display checked out books in the inventory
    public static void showCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (Books book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println(book + ", Checked out to: " + book.getCheckOutTo() + " miight look like this"); // Print book details and borrower's name
                System.out.println(
                        "⡿⣽⣻⣽⢯⡿⣽⣟⣿⣻⣟⣿⣻⡽⣏⡿⣹⢯⡽⢭⡻⣝⡯⣟⡻⣟⣻⡟⣿⢯⡿⣟⠻⡏⢽⡑⢯⡹⢯⡝⣏⠿⣙⢯⡙⢮⡙⢆⢣⠒⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠄⡄\n" +
                        "⣟⣳⢧⣟⡯⣟⣳⣟⣾⣳⣟⣾⣳⢿⣹⠾⣝⣮⢳⣏⡷⣭⢻⡼⣽⣣⢿⡾⣽⢺⡽⣋⠆⡉⠦⡘⢣⡜⣥⢛⣬⡏⣽⢒⡝⣢⣙⡌⢢⣑⣀⡠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⢂⢔⡣⣘\n" +
                        "⣿⣹⢾⣭⢿⣹⡗⣯⣞⣷⢻⣞⡽⣯⢯⣟⣳⣞⣳⢮⢷⡭⣷⡹⣧⢋⠶⡱⢏⡟⠻⢁⠊⢤⣑⡈⠆⡜⢈⠻⣭⠛⠤⣡⣾⡴⠞⠛⠛⠉⠉⠙⠛⠲⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⡐⢪⡕⢬\n" +
                        "⣷⣯⣟⣮⢯⣗⡿⣧⣟⣾⣻⡼⣯⣟⡿⣞⣧⣯⢷⣯⢯⢷⣳⡝⣦⠋⡔⢡⠈⢠⠁⠆⣸⣿⡝⣿⣦⠀⣠⠟⣸⣿⡷⠟⠁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠢⢌⡳⡜⢦\n" +
                        "⣿⢾⡽⣞⣻⢮⢿⡽⣞⣷⣳⢯⣳⢯⣻⣝⡾⣭⣟⢮⣟⡞⣧⣛⠦⡩⢔⠡⡈⠔⠠⣶⣿⣿⣷⡌⠻⣶⡁⢀⣵⠟⢀⣤⣤⣄⣀⣀⢀⣀⣀⣀⣀⣀⣠⣀⣀⡈⢳⣄⠀⠀⠀⠀⠀⢀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠂⡜⢢⢽⡙⢮\n" +
                        "⣯⢯⣟⣭⢷⣯⣻⣽⣛⡾⣽⣏⣯⠷⣏⡾⣽⡳⣞⢯⡞⣽⠲⣍⠲⡁⢋⠆⡡⠌⡁⠙⡻⢿⣿⣿⣶⣌⣻⡿⢷⣴⣿⣿⣿⡟⣿⡿⣿⣯⠉⠿⡿⣟⣯⣝⣯⣻⣶⢿⣧⡀⢀⣠⠾⣋⣷⣬⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢠⠘⡄⢣⠎⡝⢂\n" +
                        "⣿⢾⡽⣞⣯⢶⣻⢾⣽⣛⡷⣞⡧⣿⣹⠽⣶⢻⡝⣮⡝⣲⢫⠔⢣⠄⡣⢘⠰⣈⠱⡘⡘⠣⢌⠰⣉⢻⡿⠻⣿⣿⡿⠟⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⡻⣿⣿⡀⢿⣿⢋⣥⣾⣿⣿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠣⠌⡃⢬⡑⢊\n" +
                        "⣟⣯⢿⡽⣞⣯⣟⢯⡾⣝⣳⠿⣜⢧⣏⠿⣜⢯⡞⡵⢪⡕⢪⡜⡡⢊⠔⡡⠒⠤⢁⠆⠹⡐⡬⠒⣨⣿⠁⠀⠙⠻⢿⣶⣿⣿⡿⠛⠋⠉⠉⠛⠻⣯⣠⡿⣧⠙⢿⡇⠀⣿⠋⠉⠉⠉⠉⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠠⠑⢢⡑⠌\n" +
                        "⣿⢯⡿⣽⣻⣞⣭⠿⣝⣯⢳⢯⡝⡾⣜⡻⣜⢧⣫⢓⡧⣚⠥⣒⢡⠊⡔⢡⢘⡐⠈⡌⢱⡑⢆⡱⣼⠃⠀⠀⠀⠀⣀⣤⣿⣢⣤⣶⢂⠀⠀⢲⣦⡈⠙⡻⠿⠖⠋⠀⠀⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠈⠀⡜⠰⣈⠒\n" +
                        "⣿⢯⣟⡷⣻⠼⣞⣻⡝⣮⢟⡮⣽⣱⢫⡵⣫⢞⡴⣋⡞⣵⢊⡵⣊⠵⣉⢦⠣⣜⡱⣚⢦⡙⢦⣹⡏⢠⡶⣶⣿⣿⣿⡿⣿⢿⣿⣾⣭⣶⣤⣦⣿⣿⣦⣷⣦⣀⠀⠀⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠁⠂⠜⢡⢂⡱\n" +
                        "⣿⣻⡞⣷⢫⡟⡼⢧⡻⣜⡏⣾⡱⣎⠷⣱⡹⢎⡵⢳⡜⣥⠻⡴⣩⠖⣭⠲⣹⡐⢧⡙⣦⡙⢦⣿⠁⣼⣿⣿⣿⣿⣿⡀⠀⠀⠈⠛⣿⠛⣿⣻⡿⠟⠋⠛⢿⣿⣷⣆⠀⠀⣿⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠠⠀⢀⠡⢈⠰⣈⠒⢦⡑\n" +
                        "⣿⢷⣿⣉⣷⢏⣹⢷⡹⣾⡸⣇⡹⣈⢷⢇⡹⣎⡸⢇⡾⣰⠏⣱⢇⡹⣆⠿⣰⠹⢶⠹⣰⢹⢶⣿⡀⣿⡇⢏⣿⠏⠿⣿⣶⣆⣀⠀⠀⠀⣾⠏⠀⠀⠰⠆⠀⠹⣿⡹⣷⠀⣿⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠈⡀⠆⠀⠆⠁⠀⠰⠈⡰⢀⠏⣆⠹\n" +
                        "⣿⣻⢶⣻⡼⣏⢷⣫⢗⡧⣟⡴⢫⡵⢪⢎⡵⢪⡕⣫⢔⡣⠞⡥⣎⠵⣊⠷⣡⢏⠲⣽⣶⠿⠛⠉⣿⣿⡘⣆⡿⠀⠰⣷⢮⣭⣟⣛⣿⠶⠿⠶⠤⠤⠴⠬⢷⣄⢸⣿⠌⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣐⠠⠀⡁⠠⢀⢁⠢⡑⢄⢫⡘⡴⣋\n" +
                        "⣷⣯⣟⣧⢿⣹⢾⡱⣏⢾⡱⣏⢷⣚⡳⢎⡼⢣⠞⡴⢣⢞⡹⢦⡝⢮⡱⣫⣴⣭⠞⠉⠀⠀⠀⠀⠛⣿⣧⡿⢡⣀⠴⣫⢞⡭⡩⢏⡹⠛⠟⡛⠿⢷⣶⣄⠀⠙⢿⣿⡄⢠⡏⠀⠀⠌⠀⠀⠀⠀⠀⠀⠀⠀⠂⠄⠒⡀⠀⡐⠀⠰⢀⢂⠒⢌⢂⠦⣱⢣⡝\n" +
                        "⣟⡾⢮⡷⣯⣻⢧⣟⡭⣟⣳⠽⣮⢳⡝⢮⡵⢫⠞⣵⢋⡞⡹⣆⣻⡶⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡜⣱⢺⡝⣧⠟⡴⣉⠆⡠⢉⠴⡠⢇⠸⢤⣿⠆⠀⣾⣏⡷⠘⠻⣦⡐⠀⠀⠀⠀⠀⠀⠀⠀⠂⠠⠀⠃⠄⠂⠐⠀⡁⢂⠌⡘⢤⢊⠲⣡⢗⡯\n" +
                        "⡿⣽⢯⣟⡷⣯⣟⡼⣝⡮⣝⣻⡜⣯⢞⡣⢏⢧⡻⣼⣭⣶⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣝⢦⡙⠺⣥⠻⡵⡌⢆⡱⡀⠆⡑⢊⡑⢺⡿⠀⠀⢻⢿⡇⠀⠀⠈⠻⣤⡀⠀⠀⠀⠀⠀⠀⢀⠠⠁⢈⠐⠀⠌⡐⢈⠔⡨⢘⠥⣊⢖⡱⣯⢞\n" +
                        "⣿⣽⣻⢾⣽⡳⢯⡽⣞⡵⢯⡳⣝⣮⣷⡽⠿⠛⠛⠋⠉⠁⢠⣀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⣀⡿⠟⣿⣿⣿⣿⣮⣕⢦⣛⡵⣚⢦⣑⣌⡐⢀⠀⡄⠛⠁⣀⣰⣿⣼⣷⣄⠀⠀⠀⠈⠻⣦⡀⠀⠀⠄⠠⠀⡀⠂⢄⡈⠔⡨⠄⣃⠘⣄⢋⠴⣩⢮⡵⢯⣻\n" +
                        "⣟⡾⣽⢯⣶⢻⡻⣜⢧⣻⣷⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣫⣉⡉⠲⣦⣀⣤⣴⠟⠉⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣏⡷⣭⣲⣍⣦⣏⡼⣩⣷⣿⣿⣿⣧⡙⠿⣦⣄⠀⠀⠦⣈⠛⢦⣖⠀⠄⠃⠤⢁⠢⡐⢌⠰⡈⢄⠣⡌⢎⠶⣱⢮⡽⣏⣷\n" +
                        "⣯⢿⡽⣞⢧⡿⣹⣝⡶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠻⢿⣉⠀⣤⣀⣤⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣹⣿⡀⡈⠻⣧⣖⠀⠈⠳⣄⡉⠻⢾⣅⡲⢌⢂⠩⢄⠓⡌⢎⡱⢎⡹⣎⣷⣹⢾⡽⣾\n" +
                        "⣯⢷⣻⢭⣟⡼⣷⠟⠀⢀⣀⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣿⡟⠻⣯⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣰⠈⢿⣿⣆⠀⠈⠻⣧⣤⡤⠼⠳⢤⣀⡈⠙⠷⣮⣃⢎⡹⣘⢮⡱⣏⡽⣳⣝⣯⣟⣿⢿\n" +
                        "⣟⣯⢽⣛⣮⣿⠋⠀⢚⣉⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢀⠀⠀⠀⠀⠈⠙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣤⠈⠻⢦⣤⣴⡋⠀⠀⠀⠀⠀⠀⠉⠓⢤⣈⠛⢷⡼⣱⢎⣷⣹⣞⣷⣻⣾⣟⣯⣿\n" +
                        "⡿⣜⢧⢻⣾⣏⣴⡿⢟⡹⣼⡱⠎⡀⠀⠉⠑⠳⣄⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣴⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠡⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠞⠋⠀⠀⠀⠀⠀⠀⠀⠈⣧⣀⠀⠀⠀⠀⠀⠀⠀⠉⠲⣌⠻⣧⣿⢎⣷⡾⣯⣷⣿⣻⣿⣻\n" +
                        "⢳⣉⢮⡽⣹⣿⣿⣾⣿⣿⣽⣶⣥⣚⡴⣤⡤⢀⢻⠃⠀⠀⠀⠀⠀⠀⠀⠀⢠⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⠻⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⣇⠀⠀⠀⠀⠀⠀⠀⠀⠘⣧⡘⣿⣿⢾⣽⣟⣷⣿⣿⣽⣿\n" +
                        "⢣⠜⢺⣳⣿⣿⣿⣿⣿⣿⣿⣯⣷⣯⣟⣧⣛⡤⣈⢳⡆⠀⣄⡀⠀⠀⠀⠀⠉⠁⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣐⠘⠻⢟⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠈⢷⣹⣿⣿⣻⣿⣯⣷⣿⢿⣾\n" +
                        "⠢⢉⢂⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣯⢶⡍⢶⣰⢂⠈⡙⢳⢦⣽⠻⣦⣀⣀⣤⠖⠚⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⡀⠈⠻⣦⡀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣷⡿⣿⣻⣿⣻\n" +
                        "⢀⠃⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡜⡯⣔⢪⣴⣵⣯⣿⣿⣷⡿⠿⠛⠁⠋⠉⠉⠈⡆⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢙⠻⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⣄⡀⠈⣿⣦⣄⡠⢀⠄⣰⢢⣿⣿⣿⣿⣷⡿⣟⣯⣷⢿\n" +
                        "⠀⡒⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣳⣽⣮⣿⣿⣿⣿⣍⢃⠀⠀⣠⣀⡀⠀⣀⣠⡄⠀⠀⢀⡜⠁⠀⠀⠀⠀⠀⠀⢠⣬⣥⡦⢿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣶⣯⣿⣮⣵⣋⠼⣦⣯⣿⣿⣿⡿⣞⣿⣻⣽⡾⣿\n" +
                        "⠐⠉⣿⣿⣿⣿⣿⡽⢯⣟⣯⢛⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣯⣶⣷⣤⣬⣅⡛⣩⣥⠦⠄⠠⠚⠛⠂⠀⠰⠀⠀⠀⠀⠈⠚⠿⣧⠘⠛⠳⠆⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⢈⠻⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⡿⣽⣷⣻⢷⣻⣽\n" +
                        "⠀⠀⢻⣿⣿⡿⢯⡝⣧⢛⢮⡵⢊⣽⡿⠉⠣⠙⡭⢏⡳⣝⢾⣿⣿⣿⣿⣿⣏⢧⡈⢥⠉⢷⣄⠀⠀⣀⠧⠀⠀⠀⠀⠀⠀⠀⠀⣤⠀⣀⢀⣹⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠐⠦⠴⣤⣄⣲⣭⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣳⢯⣟⣯⢟⡾\n" +
                        "⡄⢁⢻⣿⣿⣝⠯⣝⡳⢯⣼⠇⢢⡿⠛⠠⠄⢛⠰⣘⠳⣎⢻⣿⣿⣿⣿⣿⣿⣯⡽⣎⡕⣆⠹⡷⠰⠷⠀⢀⣀⠐⠀⠀⠀⣀⣤⣩⣞⠋⢠⣍⣿⠇⠀⠀⠀⠀⢀⡀⠀⠀⣠⡄⠀⠀⠀⡀⢀⡤⣉⣿⣿⣿⣿⣿⡿⡿⣿⢻⢿⣟⠤⢻⣿⣯⣟⡾⣣⢏⡜\n" +
                        "⠜⣬⢿⣿⣿⢾⣹⣿⣟⢻⠋⣤⣿⠱⢈⠲⡰⢄⢆⡈⢳⡌⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣞⣧⣟⡥⣃⡄⣤⠀⠀⠀⢀⣤⣿⠟⢋⡷⠟⠿⣦⣼⣿⣷⣦⡶⣦⣤⣤⣤⡴⢾⣡⡤⠀⠀⠀⡄⣘⣶⣿⣿⣿⣿⣿⢳⡟⢷⡍⢦⢉⠞⣧⠌⢻⣿⣾⡱⣏⠾⣜\n" +
                        "⣇⠚⢬⣿⡿⣽⣿⣿⡹⣎⣳⡿⢡⠒⣇⠠⣕⣎⡼⣈⢷⡸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣷⢦⣝⢢⣡⣴⡾⠟⢋⢀⡀⠀⣀⣀⣀⣀⣤⣦⣀⠀⢠⣀⡈⠉⠉⠉⠻⠟⠀⠀⠁⡘⣼⣿⣿⣿⣿⣿⣿⣏⡳⣜⠣⢞⢣⡉⢎⡹⢎⡈⢿⣷⣝⢮⣻⢼\n" +
                        "⠋⡙⢦⣿⣿⣿⣿⣳⡻⢼⣿⡁⢧⢏⣰⢇⠶⣴⣼⡱⣏⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢾⣿⣿⣷⣎⣜⣣⢟⣤⣓⣔⣨⣍⣻⣿⣿⣿⡻⢳⠈⠙⣿⣧⣴⢀⢢⡐⣸⣵⣾⣿⣿⣿⣿⣿⣿⣿⢧⡹⣌⢏⡞⣦⡝⡦⣱⢻⣆⠼⣿⣿⣏⡾⣯\n" +
                        "⠀⠘⣷⣿⣿⣿⣿⡿⣟⣿⣿⡘⢧⣞⡜⣮⡹⣝⣶⣹⣟⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣉⣿⣿⣿⣿⣿⣿⣥⣆⣷⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡟⣼⢎⣳⢮⣜⣳⢧⣏⢿⣶⡸⣿⣭⢷⣻\n" +
                        "⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣷⢹⣾⢹⡾⣱⣿⣹⡾⣷⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⢿⡹⣎⢷⣾⣸⢷⣏⡾⡾⣿⡇⢹⣿⡾⣷\n" +
                        "⠃⠀⠀⢻⣿⣿⣿⣿⣿⣿⣟⡷⣞⣧⣟⣳⢯⣷⣻⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⡟⢻⠟⡯⣝⣯⣟⡿⣽⢯⠿⠛⠉⠄⠱⠅⢨⠁⠈⠢⠱⡙⢿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣟⡿⣝⣯⣟⣿⣟⡾⣽⣻⣿⣿⣆⠹⣿⣷\n" +
                        "⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣾⣽⣻⢾⣯⣽⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣶⣉⢶⡻⣜⠯⡙⠳⢊⡁⠁⠈⠐⠆⠀⢨⡿⠁⠀⠀⢌⢂⠩⢏⡟⣿⢿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠙\n" +
                        "⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣾⣷⣯⣞⣡⡒⡠⢄⡡⢰⣧⣆⠠⢰⢇⡀⢀⠄⣬⢎⣵⢻⡘⣧⣮⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣽⣿⣿⣿⣿⠃⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣵⣧⣾⣿⣿⣿⣿⣿⣾⣼⣧⣾⣿⣿⣞⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⡀⠒⣻⣿⣿⣿⣿⣿⣿⡻⢋⡝⣒⢦⡻⣌⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⡟⣯⠹⣭⠻⣽⢿⣿⣿⠟⡹⣍⠻⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠀⠀⠀\n" +
                        "⠀⠀⠠⢂⠥⣘⣽⣿⣿⣿⣿⣿⡫⢱⣋⠦⡙⢮⢳⢹⡓⣦⢛⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣏⣞⡿⣾⡽⣞⡽⣎⣿⣿⣟⡮⣵⢾⣹⣿⣧⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⡀\n" +
                        "⠀⠠⠑⡎⢶⣱⢾⣿⣿⣿⣿⣿⣏⢳⡘⢆⡙⢎⢧⢳⡝⣮⣻⡽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣀⠀⢠⠀\n" +
                        "⠀⠐⢈⣜⣳⢮⢿⣿⣿⣿⣿⢏⣜⠣⡝⢢⣙⢎⣮⢳⡽⣳⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡱⢎⡱⢊⠀\n" +
                        "⢠⡚⠜⣮⡟⣟⣾⣿⣿⣿⣿⢺⣍⡳⣜⢇⡞⡾⣜⣳⢿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⢟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣝⣣⣟⣯⣭⣻⢿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣻⡿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣷⣊⠅⢫⠖\n" +
                        "⢥⠘⡼⣹⣽⣿⣿⣿⣿⣿⣯⢷⣬⣳⣝⡾⣼⣳⣯⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⡿⢮⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣷⣿⣾⣿⣽⣿⣿⣿⣽⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣹⠿⣿⣿⣿⣿⣿⣿⣷⣭⣋⠝⢿⣿⣿⣿⣜⡘⢦⡙\n" +
                        "⢎⡸⣜⣷⣿⣿⣿⣿⣿⣟⣾⣻⣟⡿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠾⣜⢿⣿⣿⢾⢿⣿⡿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡽⢾⡽⣮⣓⢯⣝⣻⣿⣿⣿⣿⣿⣿⣿⣟⣻⣿⣿⣿⣿⣿⣶⡹");
            }
        }
    }



    // Method to check in a book using its ID
    public static void checkIn(int id) {
        // Check if the ID is within the valid range
        if (id >= 1 && id <= inventory.length) {
            Books book = inventory[id - 1];
            if (book != null) {
                book.checkIn();
            } else {
                System.out.println("Book not found.\n");
            }
        } else {
            System.out.println("Invalid book ID.\n");
        }
    }

    // Method to check out a book using its ID and borrower's name
    public static void checkOutBook(int id, String name) {
        // Check if the ID is within the valid range
        if (id >= 1 && id <= inventory.length) {
            Books book = inventory[id - 1];
            if (book != null) {
                book.setCheckOutTo(name);
                book.setIsCheckedOut(true);
                // Display a success message
                System.out.println("Book checked out successfully.\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⠟⠉⠉⠻⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⠿⠉⠀⠀⠀⠀⠀⠹⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⡿⠛⠉\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⡿⠟⠁⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣴⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣷⣶⣶⣦⣤⣤⣄⡀⠀⢀⣠⣾⣿⠿⠋⠀⠀⠀⠀⠀⣠\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⠶⠞⣿⠟⠋⠉⠉⠙⣻⠿⢿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⢀⡼⠁\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠁⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠁⢠⡞⠁⠀⠀⠀⢀⡴⠋⠀⢀⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⡞⠁⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣼⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⢠⠏⠀⠀⠀⠀⣰⠏⠀⠀⣠⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡥⠤⡀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣇⠀⣠⡏⠀⠀⠀⠀⣼⠁⠀⠀⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠁\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣄⣄⣼⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡶⠋⠀⠀⠀⠀⢸⣧⠀⠀⣴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢧⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠀⠀⠀⠀⣾⡿⠿⣿⡿⠁⠀⠀⠀⠀⠀⠀⣠⣶⣶⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳\n" +
                        "⠀⠀⠀⠀⠀⠀⢀⣾⠿⠛⢿⣿⣷⣄⡀⣿⠃⠀⠈⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⣠⣤⣦⣼⣿⠀⠀⠀⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⢀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣾⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⣠⣾⡿⠋⠉⠉⠁⠀⠀⠀⠀⠉⢯⡙⠻⣿⣿⣷⣤⡀⠀⠀⠀⠀⢿⣿⣿⣿⣿⡿⠃⢀⡤⠖⠋⠉⠉⠉⠉⠉⠉⠒⠦⣄⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀\n" +
                        "⣾⣿⠋⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⠀⠙⢦⣄⠉⠻⢿⣿⣷⣦⡀⠀⠈⠙⠛⠛⠋⠀⢰⠟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⠀⣴⠟⣫⣿⣿⣄⠀⠀⠀⠀⡶⢌⡙⠶⣤⡈⠛⠿⣿⣷⣦⣀⠀⠀⠀⠀⡇⠀⢻⣄⠀⠀⣠⢷⠀⠀⠀⠀⠀⡶⠀⠘⡆⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⢸⣟⢸⣿⣿⣿⣿⠀⠀⠀⠀⡇⠀⠈⠛⠦⣝⡳⢤⣈⠛⠻⣿⣷⣦⣀⠀⠀⠀⠀⠈⠙⠋⠁⠀⠛⠦⠤⠤⠚⠁⠀⠀⢳⠀⠀⠀⠈⠛⠿⠿⠿⠟⠋⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⠈⢿⣞⣿⣿⣿⠏⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠙⠳⢬⣛⠦⠀⠙⢻⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⠀⠀⠉⠛⠋⠁⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠈⣿⠉⢻⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⠀⠀⠀⣠⣄⠀⠀⢰⠶⠒⠒⢧⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⢸⡇⢸⡟⢿⣷⣦⣴⣶⣶⣶⣶⣤⣔⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⣤⠀⠀⠿⠿⠁⢀⡿⠀⠀⠀⡄⠈⠙⡷⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀⣿⠀⢸⡇⢸⡇⠀⣿⠙⣿⣿⣉⠉⠙⠿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⡇⠀⠀⠙⠷⢤⣀⣠⠴⠛⠁⠀⠀⠀⠇⠀⠀⡇⢸⡏⢹⡷⢦⣄⡀⠀⠀⠀⣿⡀⢸⡇⢸⡇⠀⡟⠀⢸⠀⢹⡷⢦⣄⣘⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⣿⣿⠢⣤⡀⠀⠀⠀⠀⠀⠀⣠⠾⣿⣿⡷⣤⣀⡇⠸⡇⢸⡇⢸⠉⠙⠳⢦⣄⡻⢿⣾⣧⣸⣧⠀⡇⠀⢸⠀⢸⡇⢤⣈⠙⠻⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⢹⣿⣷⣌⡉⠛⠲⢶⣶⠖⠛⠛⢶⣄⡉⠛⠿⣽⣿⣶⣧⣸⡇⢸⠀⠀⠀⠀⠈⠙⠲⢮⣝⠻⣿⣷⣷⣄⣸⠀⢸⡇⠀⠈⠁⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠈⠙⠻⢿⣷⣶⣤⣉⡻⢶⣄⣀⠈⠙⠳⢦⣈⡉⠻⢿⣿⣷⣾⣦⡀⠀⠀⠀⠀⠀⠀⠈⠙⠲⢭⣛⠿⣿⣷⣼⡇⠀⠀⠀⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⣀\n" +
                        "⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣷⣶⣽⣻⡦⠀⠀⠈⠙⠷⣦⣌⡙⠻⢿⣟⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠳⢯⣻⡇⠀⠀⠀⠀⠀⢸⣿⠀⣀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⢀⡏⠙⠛\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⢿⣿⣿⣿⣶⣤⣤⣤⣀⣈⠛⠷⣤⣈⡛⠷⢽⡻⢶⣄⣀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠳⢤⣀⠀⠀⢸⣿⡀⠈⠳⢤⣀⣀⣰⠃⠈⠛⠶⠶⠿⠃⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣿⡿⠛⠉⠙⠛⠛⠻⢷⣦⣄⣩⣿⠶⠖⠛⠛⠛⠛⠛⠛⠿⢷⣶⣦⣄⠀⠀⠀⠀⠉⢻⣶⣿⣿⠇⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠁⠀⠀⠀⠀⠀⠀⠀⣿⣿⠋⠀⠀⠀⠀⠀⣠⠖⠂⠀⠀⠀⠈⠙⠿⣿⣦⡄⠀⠀⣸⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⣰⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣶⣄⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⠀⠀⢀⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠙⢿⣿⣇⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡿⠦⠠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠧⠤⠄⠙⡿⠿⠦⠤⠤⠤⠤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + "\n Make Sure To Return It.");
            } else {
                // Display an error message if the book is not found
                System.out.println("Book not found.");
            }
        } else {
            // Display an error message for an invalid book ID only works for  numbers
            System.out.println("Invalid book ID.");
        }
    }

    public static void buyBook(){
        System.out.println("" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣒⢋⡤⣹⣯⣴⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⠉⣽⣿⣿⣦⣉⣿⣯⠉⠴⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠀⠆⠿⠻⠻⠟⠿⠿⢟⣶⡄⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣣⠏⠀⠀⠀⠀⠀⠀⠀⠀⠘⠇⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠀⠐⢀⠤⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡞⡁⠀⠀⠉⠀⠀⠀⠐⠂⠄⢸⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⠂⠀⠀⠀⠠⠀⠀⠀⠀⠀⠈⡻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢶⡄⠀⠀⠀⠀⠀⠀⠀⢀⣴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀⠀⠀⢀⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⠀⠀⠀⠀⠀⠀⠸⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠴⠙⣆⠀⠀⠀⠀⠀⠀⡠⢢⣿⣷⣤⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣠⡔⠈⣡⣄⡄⠀⠀⠲⠛⠂⠀⠀⠀⠈⠀⢸⣿⣿⣿⣷⣶⣯⣀⣒⡤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣠⡐⣉⣤⣶⣿⣿⣿⡇⠀⠀⠀⠀⠂⠐⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣵⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣛⡀⠀⠀⠠⢄⣀⣐⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⡆⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠤⠀⢇⣘⡒⠲⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⠀⠀⠀⠀⠀⠀\n" +
                "⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣓⠀⢰⠤⢭⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
                "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡧⠬⠀⢘⣛⣓⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
                "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣒⠐⡷⠬⢭⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀\n" +
                "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⡁⣛⣓⢲⣿⣿⣿⣿⣿⡏⠉⠛⠛⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀\n" +
                "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡶⢲⠦⢭⣽⣿⣿⣿⣿⣿⣅⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣹⣛⣒⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠾⠬⣭⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣄⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢼\n" +
                "⠻⣿⣿⣿⣿⠛⠋⢋⠁⠀⠀⠀⣶⢗⣛⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣾⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣾\n" +
                "⠀⣿⣿⣿⣷⣾⣿⠀⠀⠁⠀⠀⣸⡆⠾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣯\n" +
                "⠀⠈⠻⣿⣿⣿⣿⡆⠀⠤⠄⣰⣿⡇⣭⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⡿⠟⠋⠁\n" +
                "⠀⠀⠀⠀⠉⠺⢿⣿⣿⣿⣿⣿⣿⣧⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⡿⢹⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⡸⢡⣿⣿⣿⣿⣿⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣷⣿⣿⣿⣿⣿⣿⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀" +
        "\nJust Kidding!! We do NOT sell books smh");
    }
}
