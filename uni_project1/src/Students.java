import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Students {
    // this lets us use file_name variable in other methods
    static String file_name;
    static Student[] stArr = null;
    static Student[] new_arr;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //getting the file name
        System.out.println("enter the file name : ");
        file_name = scanner.nextLine();
        reading_file();


        menuloop:
        while (true) {
            System.out.print("1:Add New Student\n2:Edit Student\n"
                    + "3:Delete Student\n4:Sort Students\n5:Show Students\n"
                    + "6:Save To File\n7:Exit\nEnter Your Choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    sort();
                    break;
                case 5:
                    showStudents();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    break menuloop;

            }

        }

    }

    static void reading_file() throws FileNotFoundException {
        File file = new File(file_name);
        //checks if file really exists
        if (file.exists()) {
            // scanner in here reads the file data and work with the values in the file
            Scanner file_scanner = new Scanner(file);
            //It is a Scanner class method which returns true if this scanner has another token in its input
            while (file_scanner.hasNext()) {
                // reads the info in file, line by line
                String line = file_scanner.nextLine();
                // giving the lines to separate st codes names and filed and grades
                Student std = getting_students_csv(line);
            }
        }


    }// this method reads data from the file
    static Student getting_students_csv(String csv_string) {
        // recalling the Student class and declaring the std variable
        Student std = new Student();
        //stParts is an array which it takes the input csv_string which is taken by the scanner function from reading file method
        // it takes the input (csv_string) and splits the string by the comma factor
        // it assigns those strings to stParts array
        String[] stParts = csv_string.split(",");
        //the first string separated from comma is the student code
        std.stCode = Long.parseLong(stParts[0]);
        /// second one is the name (full name)
        std.stName = stParts[1];
        // third one is their field
        std.stField = stParts[2];
        // and at last is their total grade
        std.totalGrade = Double.parseDouble(stParts[3]);
        return std;
    } // using the student class this method separates grades fields and etc

    static Student[] addStudent(Student std, Student[] arr) {
        if (arr == null) {
            arr = new Student[1];
        } else {
            arr = Arrays.copyOf(arr, arr.length + 1);
        }

        arr[arr.length - 1] = std;
        return arr;
    }//addStudent

    static void addNewStudent() {
        // recalling scanner in a new method
        Scanner in = new Scanner(System.in);
        //
        Student std = new Student();
        System.out.print("Enter new student code: ");
        std.stCode = in.nextLong();
        in.nextLine();
        System.out.print("Enter new student name: ");
        std.stName = in.nextLine();
        System.out.print("Enter student field: ");
        std.stField = in.nextLine();
        System.out.print("Enter student total grade: ");
        std.totalGrade = in.nextDouble();
        in.nextLine();

        stArr = addStudent(std, stArr);

    }//addNewStudent

    static void editStudent() {
        Scanner scanner = new Scanner(System.in);
        Student std = new Student();
        showStudents();
        System.out.println("enter the student code of the student that you want to edit");
        long edit_code = scanner.nextLong();
        for (int i = 0; i < stArr.length; i++) {
            if (edit_code == stArr[i].stCode) {
                System.out.println("what info would you like to edit ?\n11:student code\n2:student name\n3:student field\n4:student grade");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("enter the new student code ");
                        long new_code = scanner.nextLong();
                        stArr[i].stCode = new_code;
                        break;

                    case 2:
                        System.out.println("print the new student name :");
                        String new_name = scanner.next();
                        stArr[i].stName = new_name;
                        break;

                    case 3:
                        System.out.println("print the new student field : ");
                        String new_field = scanner.next();
                        stArr[i].stField = new_field;
                        break;

                    case 4:
                        System.out.println("enter the new student grade ");
                        Double new_grade = scanner.nextDouble();
                        stArr[i].totalGrade = new_grade;
                        break;


                }
            }
        }


    }

    static void showStudents() {
        int length = stArr.length;
        for (int i = 0; i < length; i++) {
            System.out.println(stArr[i]);
        }
    }

    static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        new_arr = Arrays.copyOf(stArr,stArr.length-1);
        System.out.print("enter the student code that you would like to enter : ");
        long del_std = scanner.nextLong();
        for (int i = 0 , k = 0; i < stArr.length;i++){
            if (stArr[i].stCode != del_std ) {
                new_arr[k] = stArr[i];
                k++;
            }
        }
        stArr = new_arr;

    }
    static void sort(){
        Student std = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("which factor would you like to sort by : ");
        System.out.println("\n1:student code\n2:student name\n3:student field\n4:student grade");
        int choice = scanner.nextInt();
        switch (choice){
            case 1://stcode
                System.out.println("\n1-ascending \n2-descending");
                int choice_1 = scanner.nextInt();
                if (choice_1 == 1){
                    for (int i = 0;i < stArr.length; i ++){
                        for (int j = i + 1; j < stArr.length;j++){
                            if (stArr[i].stCode > stArr[j].stCode){
                                Student t = stArr[i];
                                stArr[i] = stArr[j];
                                stArr[j] = t;
                            }
                        }
                    }
                }
                else if (choice_1 == 2) {
                    for (int i = 0; i < stArr.length; i++) {
                        for (int j = i + 1; j < stArr.length; j++) {
                            if (stArr[i].stCode < stArr[j].stCode) {
                                Student t = stArr[j];
                                stArr[j] = stArr[i];
                                stArr[i] = t;
                            }
                        }
                    }
                }
                break;
            case 2:
                System.out.println("\n1-ascending \n2-descending");
                int choice_2 = scanner.nextInt();
                if (choice_2 == 1){
                    for (int i = 0;i < stArr.length; i ++){
                        for (int j = i + 1; j < stArr.length;j++){
                            if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) > 0){
                                Student t = stArr[i];
                                stArr[i] = stArr[j];
                                stArr[j] = t;
                            }
                        }
                    }
                }
                else if (choice_2 == 2) {
                    for (int i = 0; i < stArr.length; i++) {
                        for (int j = i + 1; j < stArr.length; j++) {
                            if (stArr[i].stName.compareToIgnoreCase(stArr[j].stName) < 0) {
                                Student t = stArr[j];
                                stArr[j] = stArr[i];
                                stArr[i] = t;
                            }
                        }
                    }
                }
                break;
            case 3:
                System.out.println("\n1-ascending \n2-descending");
                int choice_3 = scanner.nextInt();
                if (choice_3 == 1){
                    for (int i = 0;i < stArr.length; i ++){
                        for (int j = i + 1; j < stArr.length;j++){
                            if (stArr[i].stField.compareToIgnoreCase(stArr[j].stField) > 0){
                                Student t = stArr[i];
                                stArr[i] = stArr[j];
                                stArr[j] = t;
                            }
                        }
                    }
                }
                else if (choice_3 == 2) {
                    for (int i = 0; i < stArr.length; i++) {
                        for (int j = i + 1; j < stArr.length; j++) {
                            if (stArr[i].stField.compareToIgnoreCase(stArr[j].stField) < 0) {
                                Student t = stArr[j];
                                stArr[j] = stArr[i];
                                stArr[i] = t;
                            }
                        }
                    }
                }
                break;
            case 4:
                System.out.println("\n1-ascending \n2-descending");
                int choice_4 = scanner.nextInt();
                if (choice_4 == 1){
                    for (int i = 0;i < stArr.length; i ++){
                        for (int j = i + 1; j < stArr.length;j++){
                            if (stArr[i].totalGrade > stArr[j].totalGrade){
                                Student t = stArr[i];
                                stArr[i] = stArr[j];
                                stArr[j] = t;
                            }
                        }
                    }
                }
                else if (choice_4 == 2) {
                    for (int i = 0; i < stArr.length; i++) {
                        for (int j = i + 1; j < stArr.length; j++) {
                            if (stArr[i].totalGrade < stArr[j].totalGrade) {
                                Student t = stArr[j];
                                stArr[j] = stArr[i];
                                stArr[i] = t;
                            }
                        }
                    }
                }
                break;
}






    }
    static void saveToFile() throws FileNotFoundException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_name));
            for (int i = 0; i < stArr.length; i ++){
                writer.write(String.valueOf(stArr[i].stCode)+",");
                writer.write(stArr[i].stName + ",");
                writer.write(String.valueOf(stArr[i].stField) + ",");
                writer.write(String.valueOf(stArr[i].totalGrade) + ",");
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
