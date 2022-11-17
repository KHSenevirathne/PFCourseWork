/* Coded by KAVEESH HEMAKA SENEVIRATHNE
 * khsenevirathne@gmail.com - E-MAIL
 * 076 53 500 39 - WHATSAPP
 * for COURSE WORK REDONE
 * 11/18/2022 2.00AM*/

import java.util.*; // import java util package.
import java.text.DecimalFormat; // import decimal format for print limited decimals in double formats

class CourseWork{

    public static void main(String[] args) {

        // In  main method we create arrays for store data we need

        String [] Id = new String [100]; //for student IDs.
        String [] Name = new String[100]; //for student Names.
        int [] pfMarks = new int[100]; //for programming fundamental marks.
        int [] dbMarks = new int[100]; //for DBMS marks.

        // assign value -1 to programing fundamental marks array.
        // because we'll need to check this array with for-loop and need exit point.
        for (int i=0; i<100; i++){
            pfMarks[i]=-1;
        }

        // index is a common int variable using in [1] , [2]. Its helps add IDs in right place into array.
        int index=0;

        System.out.print("\t+-+-+-+-+-+-+-+-+-+-+-+\n\t|   WELCOME TO ALL    |\n\t+-+-+-+-+-+-+-+-+-+-+-+\n\n* Coded by KAVEESH HEMAKA SENEVIRATHNE\n* khsenevirathne@gmail.com - E-MAIL\n* 076 53 500 39 - WHATSAPP\n* for COURSE WORK REDOING\n* 11/18/2022 6.00PM\n\n\n\n>Press any key to continue . . .");
        String start = new Scanner (System.in).nextLine();//to start user calling
        clearConsole();

        menu(Id,Name,index,pfMarks,dbMarks);// call method 'menu' with arrays arguments.
    }

//-----------------------------------------------------------------------------------------------------------
//-------------------------------------------CLEAR CONSOLE---------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public final static void clearConsole() {

        // In this method using to clear the console without loosing any data.

        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
// Handle any exceptions.
        }
    }

//-------------------------------------------------------------------------------------------------------------
//-----------------------------------------------TITLES--------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public static void menu(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks) {

        //this method show only titles of program.

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                 WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                    |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("[1] Add New Student                   [2] Add New student With Marks");
        System.out.println("[3] Add Marks                         [4] Update Student Details");
        System.out.println("[5] Update Marks                      [6] Delete Student");
        System.out.println("[7] Print Student Details             [8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals  [10] Best in Database Management System");
        System.out.println();

        choose(Id,Name,index,pfMarks,dbMarks);// call method 'choose' with arrays argument.

    }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------CHOOSE TITLES-----------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public static void choose(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks) {

        // asking from user and get option through scanner input.
        System.out.print("Enter an option to continue > ");
        String topic = new Scanner(System.in).nextLine();

        // check user input with switch

        switch (topic) {
            case "1":
                clearConsole();
                addNewStudentTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "2":
                clearConsole();
                addNewStudentWithMarksTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "3":
                clearConsole();
                addMarksTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "4":
                clearConsole();
                updateStudentTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "5":
                clearConsole();
                updateMarksTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "6":
                clearConsole();
                deleteTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "7":
                clearConsole();
                printTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "8":
                clearConsole();
                rankTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "9":
                clearConsole();
                bestPfTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            case "10":
                clearConsole();
                bestDbTitle(Id, Name, index, pfMarks, dbMarks);

                break;
            default:

                // if user had input wrong run this statements

                System.out.print("Invalid Input..!!\nDo you want continue ? (y/n) : ");
                char choose = new Scanner(System.in).next().charAt(0);
                System.out.println();
                if (choose == 'y' | choose == 'Y') {
                    choose(Id, Name, index, pfMarks, dbMarks);
                }
                else{
                    clearConsole();
                    System.out.println("\t+-+-+-+-+-+-+-+-+-+-+-+\n\t|   HAPPY CODING ;P   |\n\t+-+-+-+-+-+-+-+-+-+-+-+");
                }
        }
    }

//-------------------------------------------------------------------------------------------------------------
//----------------------------------------[1] ADD STUDENT------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public static void addNewStudent(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println();

        //get student Id from user and add to temporary variable
        System.out.print("Enter Student ID: ");
        String temp=new Scanner(System.in).nextLine();

        //check 'temp' variable, if its already in 'Id' array
        for (String s : Id) {

            if (temp.equals("")) {
                System.out.println("Please enter correct ID.");
                addNewStudent(Id, Name, index, pfMarks, dbMarks);
            }
            if (temp.equals(s)) {
                System.out.println("The Student ID already exists.");
                addNewStudent(Id, Name, index, pfMarks, dbMarks);
            }
        }
        Id[index]=temp; // add to Id to 'Id' array

        //get student name from user and add to  'Name' array
        System.out.print("Enter Student Name: ");
        Name[index] = new Scanner(System.in).nextLine();

        index++; //increment index. to add new values.
        System.out.println();
        System.out.println("Student has been added successfully.");

        System.out.print("Do you want to add a new student (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        clearConsole();
        if (choose == 'y' | choose == 'Y') {
            addNewStudentTitle(Id,Name,index,pfMarks,dbMarks);

        }else{
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-------------------------------------------------------------------------------------------------------------
//----------------------------------[2] ADD STUDENT WITH MARKS-------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    public static void addStudentMarks(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //get student Id from user and add to temporary variable
        System.out.println();
        System.out.print("Enter Student ID: ");
        String temp=new Scanner(System.in).nextLine();

        //check 'temp' variable, if its already in 'Id' array
        for (String s : Id) {

            if (temp.equals("")) {
                System.out.println("Please enter correct ID.");
                addStudentMarks(Id, Name, index, pfMarks, dbMarks);
            }
            if (temp.equals(s)) {
                System.out.println("The Student ID already exists.");
                addStudentMarks(Id, Name, index, pfMarks, dbMarks);
            }
        }
        Id[index]=temp; // add to Id to 'Id' array

        //get student name from user and add to  'Name' array
        System.out.print("Enter Student Name: ");
        Name[index] = new Scanner(System.in).nextLine();

        //get 'Programming Fundamentals Marks' from user and add to temporary variable
        System.out.println();
        System.out.print("Programming Fundamentals Marks : ");
        int tempm=new Scanner(System.in).nextInt();

        //check 'Programming Fundamentals Marks' >100 or <0
        while (tempm>100| tempm<0){
            System.out.println("Invalid marks. please enter correct marks.");
            System.out.println();
            System.out.print("Programming Fundamentals Marks : ");
            tempm=new Scanner(System.in).nextInt();
        }
        pfMarks[index]=tempm;

        //get 'Database Management System Marks' from user and add to temporary variable
        System.out.print("Database Management System Marks : ");
        tempm=new Scanner(System.in).nextInt();

        //check 'Database Management System Marks' >100 or <0
        while (tempm>100| tempm<0){
            System.out.println("Invalid marks. please enter correct marks.");
            System.out.println();
            System.out.print("Database Management System Marks : ");
            tempm=new Scanner(System.in).nextInt();
        }
        dbMarks[index]=tempm;

        index++;

        System.out.println();
        System.out.println("Student has been added successfully.");
        System.out.print("Do you want to add a new student (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        clearConsole();
        if (choose == 'y' | choose == 'Y') {
            addNewStudentWithMarksTitle(Id,Name,index,pfMarks,dbMarks);

        }else{
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//-------------------------------------[3] ADD MARKS---------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void addMarks(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //get student Id from user
        System.out.println();
        System.out.print("Enter Student ID :");
        String temp= new Scanner(System.in).nextLine();

        //check id Id equals to Ids in array 'Id'.
        for (int i = 0; i<Id.length; i++){

            if (temp.equals("")){break;}
            if(temp.equals(Id[i])) {
                System.out.println("Student Name : " + Name[i]);
                System.out.println();

                //check did 'Programming Fundamentals Marks' already added.
                //If pfMarks!=-1 means marks are already define
                if(pfMarks[i]!=-1){
                    System.out.println("This student's Marks have been already added.\n" +
                            "If you want to update the Marks. Please use Update Marks[4] option.");
                    System.out.print("Do you want to add a new student (Y/n): ");

                    char choose = new Scanner(System.in).next().charAt(0);

                    clearConsole();
                    if (choose == 'y' | choose == 'Y') {
                        addMarksTitle(Id,Name,index,pfMarks,dbMarks);

                    }else{
                        menu(Id,Name,index,pfMarks,dbMarks);
                    }
                }

                //Add marks
                System.out.print("Programming Fundamentals Marks : ");
                int tempm=new Scanner(System.in).nextInt();

                while (tempm>100| tempm<0){
                    System.out.println("Invalid marks. please enter correct marks.");
                    System.out.println();
                    System.out.print("Programming Fundamentals Marks : ");
                    tempm=new Scanner(System.in).nextInt();
                }
                pfMarks[i]=tempm;

                System.out.print("Database Management System Marks : ");
                tempm=new Scanner(System.in).nextInt();

                while (tempm>100| tempm<0){
                    System.out.println("Invalid marks. please enter correct marks.");
                    System.out.println();
                    System.out.print("Database Management System Marks : ");
                    tempm=new Scanner(System.in).nextInt();
                }
                dbMarks[i]=tempm;

                System.out.println();
                System.out.println("Student has been added successfully.");
                System.out.print("Do you want to add a new student (Y/n): ");

                char choose = new Scanner(System.in).next().charAt(0);

                clearConsole();
                if (choose == 'y' | choose == 'Y') {
                    addMarksTitle(Id,Name,index,pfMarks,dbMarks);

                }else{
                    menu(Id,Name,index,pfMarks,dbMarks);
                }
            }
        }

        //if input invalid Id.
        System.out.println();
        System.out.println("Invalid student ID.");
        System.out.print("Do you want to add a new student (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        if (choose == 'y' | choose == 'Y') {
            addMarks(Id,Name,index,pfMarks,dbMarks);

        }else{
            clearConsole();
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//--------------------------------[4] UPDATE STUDENT NAME----------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void updateStudent(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //get id and show name
        System.out.println();
        System.out.print("Enter Student ID :");
        String temp = new Scanner(System.in).nextLine();

        for (int i=0; i<Id.length; i++){

            if (temp.equals("")){break;}
            if (temp.equals(Id[i])){
                System.out.println("Student Name : "+Name[i]);

                System.out.println();
                System.out.print("Enter the new student name : ");
                Name[i]=new Scanner(System.in).nextLine(); // replace name

                System.out.println();
                System.out.println("Student has been updated successfully.");
                System.out.print("Do you want to update another student details? (Y/n): ");
                char choose = new Scanner(System.in).next().charAt(0);

                clearConsole();
                if (choose == 'y' | choose == 'Y') {
                    updateStudentTitle(Id,Name,index,pfMarks,dbMarks);

                }else{
                    menu(Id, Name, index, pfMarks, dbMarks);
                }
            }
        }
        // entered wrong ID
        System.out.println();
        System.out.println("Invalid student ID.");
        System.out.print("Do you want to try again ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        if (choose == 'y' | choose == 'Y') {
            updateStudent(Id,Name,index,pfMarks,dbMarks);

        }else{
            clearConsole();
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//---------------------------------[5] UPDATE MARKS STUDENT--------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void updateMarks(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //get input from user
        System.out.println();
        System.out.print("Enter Student ID :");
        String temp = new Scanner(System.in).nextLine();

        for (int i=0; i<Id.length; i++){

            if (temp.equals("")){break;}
            if (temp.equals(Id[i])){
                System.out.println("Student Name : "+Name[i]);// print student name if ID is correct
                System.out.println();

                //check marks already add or nor, pfMarks==-1 means marks not added. so cant update
                if (pfMarks[i]==-1){
                    System.out.println("This student's marks yet to be added.");

                    System.out.print("Do you want to update the marks of another student ? (Y/n): ");
                    char choose = new Scanner(System.in).next().charAt(0);

                    if (choose == 'y' | choose == 'Y') {
                        updateMarks(Id,Name,index,pfMarks,dbMarks);

                    }else{
                        clearConsole();
                        menu(Id,Name,index,pfMarks,dbMarks);
                    }
                }

                //if marks already assign. show old marks.
                System.out.println("Programming Fundamentals Marks :"+pfMarks[i]);
                System.out.println("Database Management System Marks :"+dbMarks[i]);

                //replace old marks with new marks
                System.out.println();
                System.out.print("Enter new Programming Fundamentals Marks :");
                int tempm=new Scanner(System.in).nextInt();
                while (tempm>100| tempm<0){
                    System.out.println("Invalid marks. please enter correct marks.");
                    System.out.println();
                    System.out.print("Enter new Programming Fundamentals Marks : ");
                    tempm=new Scanner(System.in).nextInt();
                }
                pfMarks[i]=tempm;

                System.out.print("Enter new Database Management System Marks :");
                tempm=new Scanner(System.in).nextInt();
                while (tempm>100| tempm<0){
                    System.out.println("Invalid marks. please enter correct marks.");
                    System.out.println();
                    System.out.print("Enter new Database Management System Marks : ");
                    tempm=new Scanner(System.in).nextInt();
                }
                dbMarks[i]=tempm;

                System.out.println();
                System.out.println("Marks have been updated successfully.");
                System.out.print("Do you want to update marks for another student ? (Y/n): ");

                char choose = new Scanner(System.in).next().charAt(0);

                clearConsole();
                if (choose == 'y' | choose == 'Y') {
                    updateMarksTitle(Id,Name,index,pfMarks,dbMarks);

                }else{
                    menu(Id, Name, index, pfMarks, dbMarks);
                }
            }
        }
        System.out.println();
        System.out.println("Invalid student ID.");
        System.out.print("Do you want to try again ? (Y/n): ");

        char choose = new Scanner(System.in).next().charAt(0);

        if (choose == 'y' | choose == 'Y') {
            updateMarks(Id,Name,index,pfMarks,dbMarks);

        }else{
            clearConsole();
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//---------------------------------[6] DELETE STUDENT DETAIL-------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void delete(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        System.out.println();
        System.out.print("Enter Student ID :");
        String temp = new Scanner(System.in).nextLine();

        // check given ID equals any IDs in array.
        for (int i=0; i<Id.length; i++){

            if (temp.equals("")){break;}
            if (temp.equals(Id[i])){

                //when equals delete items from all arrays.
                Id[i]="";
                Name[i]=null;
                pfMarks[i]=-1;
                dbMarks[i]=0;

                System.out.println("Student has been deleted successfully.");

                System.out.print("Do you want to delete another student ? (Y/n): ");
                char choose = new Scanner(System.in).next().charAt(0);

                if (choose == 'y' | choose == 'Y') {
                    delete(Id,Name,index,pfMarks,dbMarks);

                }else{
                    clearConsole();
                    menu(Id,Name,index,pfMarks,dbMarks);
                }
            }
        }

        //when didn't equals with any ID.
        System.out.println();
        System.out.println("Invalid student ID.");
        System.out.print("Do you want to search again ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        if (choose == 'y' | choose == 'Y') {
            delete(Id,Name,index,pfMarks,dbMarks);

        }else{
            clearConsole();
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//----------------------------------[7] PRINT STUDENT DETAIL-------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void print(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println();
        System.out.print("Enter Student Id : ");
        String temp = new Scanner(System.in).nextLine();

        //search ID
        for (int i=0; i<Id.length; i++){

            if (temp.equals("")){break;}
            if (temp.equals(Id[i])){
                System.out.println("Student Name: "+Name[i]);
                System.out.println();

                // check marks are already in arrays. if not don't show details
                if (pfMarks[i]==-1){
                    System.out.println("Marks yet to be added.");
                    System.out.println();

                    System.out.print("Do you want to search another student details ?(Y/n) : ");
                    char choose = new Scanner(System.in).next().charAt(0);

                    clearConsole();
                    if (choose=='y' | choose=='Y'){
                        printTitle(Id,Name,index,pfMarks,dbMarks);

                    }else{
                        menu(Id,Name,index,pfMarks,dbMarks);
                    }
                }

                //if ID was correct and marks were in arrays. then prints below
                System.out.println("+-----------------------------------+-----------------+");

                System.out.print("|Programming Fundamentals Marks     |");
                System.out.printf("%17d",pfMarks[i]); //programming fundamental marks
                System.out.println("|");

                System.out.print("|Database Management System Marks   |");
                System.out.printf("%17d",dbMarks[i]); //database management marks
                System.out.println("|");

                System.out.print("|Total Marks                        |");
                System.out.printf("%17d",(pfMarks[i]+dbMarks[i])); //total
                System.out.println("|");

                System.out.print("|Avg. Marks                         |");
                System.out.printf("%17s",numberFormat.format((pfMarks[i]+dbMarks[i])/2.0)); //average
                System.out.println("|");

                System.out.print("|Rank                               |");
                System.out.printf("%17s",importRank(Id[i],Id,pfMarks,dbMarks)); //rank import from another method
                System.out.println("|");

                System.out.println("+-----------------------------------+-----------------+");
                System.out.println();

                System.out.print("Do you want to search another student details ?(Y/n) : ");
                char choose = new Scanner(System.in).next().charAt(0);

                clearConsole();
                if (choose=='y' | choose=='Y'){
                    printTitle(Id,Name,index,pfMarks,dbMarks);

                }else{
                    menu(Id,Name,index,pfMarks,dbMarks);
                }
            }
        }
        //if ID cant find
        System.out.println();
        System.out.println("Invalid student ID.");
        System.out.print("Do you want to search again ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        if (choose == 'y' | choose == 'Y') {
            print(Id,Name,index,pfMarks,dbMarks);

        }else{
            clearConsole();
            menu(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//------------------------------------[8] PRINT STUDENT RANK-------------------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void rank(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        //create array and add total of programming marks and database marks
        System.out.println();
        int[] tot = new int [100];
        for (int i=0; i<100; i++){
            tot[i]=pfMarks[i]+dbMarks[i];
        }

        //create array named 'rank' and values from array 'tot'
        int[] rank = new int [100];
        System.arraycopy(tot, 0, rank, 0, tot.length);

        //sort 'rank' array high to low marks.
        for (int j=99; j>0; j--){
            for (int i=0; i<j; i++){
                if (rank[i]<rank[i+1]){
                    int temp = rank[i];
                    rank[i]=rank[i+1];
                    rank[i+1]=temp;
                }
            }
        }

        //check 'rank' array already have marks. isn't cant print ranks
        int temp=0;
        for (int value : rank) {
            if (value == -1) {
                temp++;
            } //if all elements in rank -1 means no marks in array.
        }
        if(temp==100){
            System.out.println("Sorry!!! There are no values for get rank table.");
            System.out.print("Do you want to go back menu ? (Y/n): ");
            char choose = new Scanner(System.in).next().charAt(0);

            if (choose == 'y' | choose == 'Y') {
                clearConsole();
                menu(Id,Name,index,pfMarks,dbMarks);

            }else{rank(Id,Name,index,pfMarks,dbMarks);}
        }

        //prints ranks
        System.out.println("+-----+---------+-----------------------+---------------+---------------+");
        System.out.println("|Rank |ID       |Name                   |Total Marks    |Avg.Marks      |");
        System.out.println("+-----+---------+-----------------------+---------------+---------------+");

        for (int i = 0; i < rank.length; i++)
        {
            if(rank[i]==-1){break;} //exit loop when element == -1

            for (int j = 0; j < tot.length; j++)
            {
                if (rank[i]==tot[j]) //find what value in totals equals to ranks
                {
                    System.out.printf("|%-5d",(i+1)); //rank
                    System.out.printf("|%-9s",Id[j]); //ID
                    System.out.printf("|%-23s",Name[j]); //name
                    System.out.printf("|%15d",tot[j]); //total
                    System.out.printf("|%15s",numberFormat.format(tot[j]/2.0)); //average
                    System.out.println("|");

                    tot[j]=-1;//printed total values delete. so its stops duplicate same values
                }
            }

        }
        System.out.println("+-----+---------+-----------------------+---------------+---------------+");
        System.out.println();

        System.out.print("Do you want to go back menu ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        clearConsole();
        if (choose == 'y' | choose == 'Y') {
            menu(Id,Name,index,pfMarks,dbMarks);

        }else{
            rankTitle(Id,Name,index,pfMarks,dbMarks);
        }
    }
//-----------------------------------------------------------------------------------------------------------
//-----------------------IMPORT RANK TO PRINT STUDENT DETAIL METHOD AND PRINT WITH NAME----------------------
//-----------------------------------------------------------------------------------------------------------

    public static String importRank(String id,String[]Id,int[]pfMarks,int[]dbMarks){

        //this is helping method for program to create rank index correctly
        //create array to get total.
        int[] total = new int [100];
        for (int i=0; i<100; i++){
            total[i]=pfMarks[i]+dbMarks[i];
        }

        //create 'rank' array with total data and sort as high to min marks
        int [] rank = new int [100];
        System.arraycopy(total, 0, rank, 0, total.length);

        for (int i = 99; i > 0 ; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(rank[j]<rank[j+1]){
                    int temp = rank[j];
                    rank[j] = rank[j+1];
                    rank[j+1] = temp;
                }
            }
        }

        //check imported Id equals what index in Id array
        int i;
        for (i = 0; i < Id.length; i++)
        {
            if(Id[i].equals(id)){break;}
        }

        //copy Id index to 'temp' and find total and check which rank index equals it
        int temp = i;
        for (int j = 0; j < rank.length ; j++) {
            if (total[temp] == rank[j]) {
                temp = j; //get rank index
                break;
            }
        }

        temp++; //increment index in 1 because to get element number
        String x ="";

        //this statements used to print student rank in word its using in [7]

        if (temp==1){x=" (first)";}
        else if (temp==2){x=" (second)";}
        else if (temp==3){x=" (third)";}

        // find last to print
        int c = 0;
        for (int value : rank) {
            if (value != -1) {
                c++;
            }
        }
        if(c>3 & temp==c){x=" (last)";}


        return String.valueOf(temp+x); // return rank number with name
    }
//-----------------------------------------------------------------------------------------------------------
//---------------------------------[9] BEST IN PROGRAMMING FUNDAMENTAL MARKS---------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void bestPf(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //create array and copy data
        int [] pfRank = new int [100];
        System.arraycopy(pfMarks, 0, pfRank, 0, pfMarks.length);

        int [] tempPfMarks = new int [100];
        System.arraycopy(pfMarks, 0, tempPfMarks, 0, tempPfMarks.length);

        //sort 'pfRank' array high to low marks
        for (int i = 99; i > 0 ; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(pfRank[j]<pfRank[j+1]){
                    int temp = pfRank[j];
                    pfRank[j] = pfRank[j+1];
                    pfRank[j+1] = temp;
                }
            }
        }

        //check already data in arrays using 'pfMarks' array
        int temp=0;
        for (int pfMark : pfMarks) {
            if (pfMark == -1) {
                temp++;
            }
        }

        if(temp==100){
            System.out.println("Sorry!!! There are no values for get rank table.");

            System.out.print("Do you want to go back menu ? (Y/n): ");
            char choose = new Scanner(System.in).next().charAt(0);

            clearConsole();
            if (choose == 'y' | choose == 'Y') {
                menu(Id,Name,index,pfMarks,dbMarks);

            }else{
                bestPfTitle(Id,Name,index,pfMarks,dbMarks);}
        }

        //prints best in programming
        System.out.println("+---------+-------------------------+---------------+---------------+");
        System.out.println("|ID       |Name                     |PF Marks       |DBMS Marks     |");
        System.out.println("+---------+-------------------------+---------------+---------------+");


        for (int value : pfRank) {
            if (value == -1) {
                break;
            }  //check loop exit point
            for (int j = 0; j < tempPfMarks.length; j++) {
                if (value == tempPfMarks[j])//find which 'tempPfMarks' index equals to rank index
                {
                    System.out.printf("|%-9s", Id[j]); // ID
                    System.out.printf("|%-25s", Name[j]); // name
                    System.out.printf("|%-15s", tempPfMarks[j]); // sorted programming marks
                    System.out.printf("|%-15s", dbMarks[j]); // database marks
                    System.out.println("|");
                    tempPfMarks[j] = -1; //printed pfMarks values delete. so its stops duplicate same values
                }
            }

        }
        System.out.println("+---------+-------------------------+---------------+---------------+");
        System.out.println();

        System.out.print("Do you want to go back menu ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        clearConsole();
        if (choose == 'y' | choose == 'Y') {
            menu(Id,Name,index,pfMarks,dbMarks);

        }else{
            bestPfTitle(Id,Name,index,pfMarks,dbMarks);}

    }
//-----------------------------------------------------------------------------------------------------------
//------------------------------[10] BEST IN DATABASE MANAGEMENT MARKS---------------------------------------
//-----------------------------------------------------------------------------------------------------------

    public static void bestDb(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){

        //create array and copy data
        int [] dbRank = new int [100];
        System.arraycopy(dbMarks, 0, dbRank, 0, dbMarks.length);

        int [] pfRank = new int [100];
        System.arraycopy(pfMarks, 0, pfRank, 0, pfMarks.length);

        int [] tempDbMarks = new int [100];
        System.arraycopy(dbMarks, 0, tempDbMarks, 0, tempDbMarks.length);

        //sort 'dbRank' high to min
        for (int i = 99; i > 0 ; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(dbRank[j]<dbRank[j+1]){
                    int temp = dbRank[j];
                    dbRank[j] = dbRank[j+1];
                    dbRank[j+1] = temp;
                }
            }
        }

        //sort 'pfRank' high to min
        for (int i = 99; i > 0 ; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if(pfRank[j]<pfRank[j+1]){
                    int temp = pfRank[j];
                    pfRank[j] = pfRank[j+1];
                    pfRank[j+1] = temp;
                }
            }
        }

        //check already data in arrays using 'pfMarks' array. because -1 values only in this array.
        int temp=0;
        for (int pfMark : pfMarks) {
            if (pfMark == -1) {
                temp++;
            }
        }

        if(temp==100){
            System.out.println("Sorry!!! There are no values for get rank table.");
            System.out.print("Do you want to go back menu ? (Y/n): ");
            char choose = new Scanner(System.in).next().charAt(0);

            clearConsole();
            if (choose == 'y' | choose == 'Y') {
                menu(Id,Name,index,pfMarks,dbMarks);

            }else{
                bestDbTitle(Id,Name,index,pfMarks,dbMarks);}
        }

        //prints
        System.out.println("+---------+-------------------------+---------------+---------------+");
        System.out.println("|ID       |Name                     |DBMS Marks     |PF Marks       |");
        System.out.println("+---------+-------------------------+---------------+---------------+");


        for (int i = 0; i < pfRank.length; i++)
        {
            if(pfRank[i]==-1){break;}   //check loop exit point
            for (int j = 0; j < tempDbMarks.length; j++)
            {

                if (dbRank[i]==tempDbMarks[j])  //find which 'tempDbMarks' index equals to rank index
                {
                    if(dbRank[i]==0 & pfMarks[j]==-1){continue;} //if marks 0 maintain loop

                    System.out.printf("|%-9s",Id[j]); //ID
                    System.out.printf("|%-25s",Name[j]); //name
                    System.out.printf("|%-15d",tempDbMarks[j]); //sorted database marks
                    System.out.printf("|%-15d",pfMarks[j]);//programming marks
                    System.out.println("|");
                    tempDbMarks[j]=-1;//printed dbMarks values delete. so its stops duplicate same values

                }
            }

        }
        System.out.println("+---------+-------------------------+---------------+---------------+");

        System.out.println();
        System.out.print("Do you want to go back menu ? (Y/n): ");
        char choose = new Scanner(System.in).next().charAt(0);

        clearConsole();
        if (choose == 'y' | choose == 'Y') {
            menu(Id,Name,index,pfMarks,dbMarks);

        }else{
            bestDbTitle(Id,Name,index,pfMarks,dbMarks);}
    }


//-----------------------------------------------------------------------------------------------------------
//-------------------------------------IMPORT HEADER TO METHODS----------------------------------------------
//-----------------------------------------------------------------------------------------------------------


    public static void addNewStudentTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                             ADD NEW STUDENT                                |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        addNewStudent(Id,Name,index,pfMarks,dbMarks);
    }
    public static void addNewStudentWithMarksTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                       ADD NEW STUDENT WITH MARKS                           |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        addStudentMarks(Id,Name,index,pfMarks,dbMarks);
    }
    public static void addMarksTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                 ADD MARKS                                  |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        addMarks(Id,Name,index,pfMarks,dbMarks);
    }
    public static void updateStudentTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                             UPDATE STUDENT DETAILS                         |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        updateStudent(Id,Name,index,pfMarks,dbMarks);
    }
    public static void updateMarksTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                 UPDATE MARKS                               |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        updateMarks(Id,Name,index,pfMarks,dbMarks);
    }
    public static void deleteTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               DELETE STUDENT                               |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        delete(Id,Name,index,pfMarks,dbMarks);
    }
    public static void printTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                           PRINT STUDENT DETAILS                            |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        print(Id,Name,index,pfMarks,dbMarks);
    }
    public static void rankTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                           PRINT STUDENTS' RANKS                            |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        rank(Id,Name,index,pfMarks,dbMarks);
    }
    public static void bestPfTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                     BEST IN PROGRAMMING FUNDAMENTALS                       |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        bestPf(Id,Name,index,pfMarks,dbMarks);
    }
    public static void bestDbTitle(String[]Id,String[]Name,int index,int[]pfMarks,int[]dbMarks){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                     BEST IN DATABASE MANAGEMENT SYSTEM                     |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        bestDb(Id,Name,index,pfMarks,dbMarks);
    }
}
