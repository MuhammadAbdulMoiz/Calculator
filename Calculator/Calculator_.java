import java.util.Scanner;

public class Calculator_ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creates a Scanner object

        while (true) {
            float sum = 0, mul = 1;
            System.out.print("""
                    Chose your input data type.
                    1.Decimal\t2.Binary
                    3.Octal\t\t4.HexDecimal
                    5.Terminate Program
                    Your choice is:\s""");
            byte choice = input.nextByte(); //inputs choice of user
            if(choice == 5) System.exit(0);  // exits from the program
            switch (choice) {
                case 1 -> {
                    while (true) {
                        System.out.print("""
                                What operation do u want to perform
                                1.Addition\t\t\t2.Subtraction
                                3.Multiplication\t4.Division
                                5.Conversion\t\t6.Back
                                Your choice is:\s""");
                        byte dec_choice = input.nextByte();
                        System.out.println(" ");
                        if (dec_choice == 6) break;
                        switch (dec_choice) {
                            case 1 -> {
                                boolean cond = true;
                                byte i = 1;
                                do {
                                    System.out.print("Enter the " + i + " number: ");
                                    float num = input.nextFloat();
                                    System.out.println(" ");
                                    if (i >= 2) {
                                        if (num == 0) {
                                            cond = false;
                                        }
                                        if (cond) {
                                            System.out.println("\nPress 0 if u want to exit");
                                        }

                                    }
                                    sum += num;
                                    i++;

                                } while (cond);
                                System.out.println("Sum is " + sum);
                            }
                            case 2 -> {
                                System.out.print("Enter the first number: ");
                                float num1 = input.nextFloat();
                                System.out.print("Enter the second number: ");
                                float num_2 = input.nextFloat();
                                System.out.println("The difference is " + (num1 - num_2));
                            }
                            case 3 -> {
                                byte i = 1;
                                boolean cond = true;
                                do {
                                    System.out.print("Enter number" + i + ": ");
                                    float num = input.nextFloat();
                                    System.out.println(" ");
                                    if (i >= 2) {
                                        if (num == 0) {
                                            cond = false;
                                        }
                                        if (cond) {
                                            System.out.println("\nPress 0 if u want to exit");
                                        }

                                    }
                                    if (num != 0) mul *= num;
                                    i++;

                                } while (cond);
                                System.out.println("Product is " + mul);
                            }
                            case 4 -> {
                                System.out.print("Enter the first number: ");
                                float num1 = input.nextFloat();
                                System.out.print("Enter the second number: ");
                                float num_2 = input.nextFloat();
                                System.out.printf("The quotient is %.2f", (num1 / num_2));
                            }
                            case 5 -> {
                                System.out.print("""
                                        Convert to
                                        1.Binary
                                        2.Octal
                                        3.HexDecimal
                                        4.Back
                                        Enter your choice:\s""");
                                byte con_choice = input.nextByte();
                                if (con_choice == 4) break;
                                System.out.print("\nEnter the number: ");
                                int num = input.nextInt();
                                switch (con_choice) {
                                    case 1 -> System.out.println("Corresponding number in Binary is "
                                            +Integer.toBinaryString(num));
                                    case 2 -> System.out.println("Corresponding number in Octal is "
                                            +Integer.toOctalString( num));
                                    case 3 -> System.out.println("Corresponding number in Hex Decimal is "
                                            +Integer.toHexString( num));
                                    default -> System.out.println("Please Enter between 1 and 3");
                                }
                            }
                            default -> System.out.println("Please Enter between 1 and 6");
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.print("""
                                What operation do u want to perform
                                1.Binary Addition\t2.Binary Subtraction
                                3.Conversion\t\t4.Back
                                Your choice is:\s""");
                        byte bin_choice = input.nextByte();
                        System.out.println(" ");
                        if (bin_choice == 4) break;
                        switch (bin_choice) {
                            case 1 -> {
                                //code for binary addition
                                System.out.print("Enter first binary number: ");
                                String num1 = input.next();
                                System.out.print("Enter second binary number: ");
                                String num2 = input.next();
                                int res = Integer.valueOf(num1,2)+Integer.valueOf(num2,2);
                                System.out.println("The result is "+ Integer.toBinaryString(res));
                            }
                            case 2 -> {
                                //code for binary subtraction
                                System.out.print("Enter first binary number: ");
                                String num1 = input.next();
                                System.out.print("Enter second binary number: ");
                                String num2 = input.next();
                                int b1 = Integer.parseInt(num1,2);
                                int b2 = Integer.parseInt(num2,2);
                                int res = b1 + (~b2+1); //b1 + 2's complement of b2 gives (b1-b2)
                                System.out.println("The difference is "
                                        +Integer.toBinaryString(res));
                            }
                            case 3 -> {
                                while (true) {

                                    System.out.print("""
                                            Convert to
                                            \b1.Decimal\t\t\b2.Octal
                                            \b3.HexDecimal\t4.Back
                                            Your choice is:\s""");
                                    byte con_choice = input.nextByte();
                                    if (con_choice == 4) break;
                                    System.out.print("Enter the number: ");
                                    String num = input.next();
                                    switch (con_choice) {
                                        case 1 -> System.out.println("Corresponding number in decimal is "
                                                + Integer.valueOf(num, 2));
                                        case 2 -> {
                                            int dec = Integer.valueOf(num, 2);
                                            System.out.println("Corresponding number in octal is "
                                                    + Integer.toOctalString(dec));
                                        }
                                        case 3 -> {
                                            int dec = Integer.valueOf(num, 2);
                                            System.out.println("Corresponding number in Hex Decimal is "
                                                    + Integer.toHexString(dec));
                                        }
                                        default -> System.out.println("Invalid input\n");
                                    }

                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    while (true) {
                        System.out.print("""

                                What operation do u want to perform
                                1.Octal Addition\t2.Octal Subtraction
                                3.Conversion\t\t4.Back
                                Your choice is:\s""");
                        byte oct_choice = input.nextByte();
                        System.out.println(" ");
                        if(oct_choice == 4) break;
                        switch (oct_choice){
                            case 1 -> {
                                //code for octal addition
                                System.out.print("Enter first octal number: ");
                                String num1 = input.next();
                                System.out.print("Enter second octal number: ");
                                String num2 = input.next();
                                int o1 = Integer.valueOf(num1, 8);
                                int o2 = Integer.valueOf(num2, 8);
                                String res = Integer.toOctalString((o1+o2));
                                System.out.println("The result is "+res);
                            }
                            case 2 -> {
                                //code for octal subtraction
                                System.out.print("Enter first octal number: ");
                                String num1 = input.next();
                                System.out.print("Enter second octal number: ");
                                String num2 = input.next();
                                int o1 = Integer.valueOf(num1, 8);
                                int o2 = Integer.valueOf(num2, 8);
                                int res = o1 + (~o2+1);
                                System.out.println("The result is "+Integer.toOctalString(res));
                            }
                            case 3 -> {
                                //code for conversion
                                System.out.print("""
                                        Convert To
                                        1.Decimal\t\t2.Binary
                                        3.Hex Decimal\t4.Back
                                        Your Choice:\s""");
                                byte con_choice = input.nextByte();
                                if (con_choice == 4) break;
                                System.out.print("Enter the number in octal: ");
                                String num = input.next();

                                switch (con_choice){
                                    case 1 -> System.out.println("Corresponding number in decimal is"
                                            +Integer.valueOf(num,8));
                                    case 2 -> {
                                        int dec = Integer.valueOf(num, 8);
                                        System.out.println("Corresponding value in Binary is "
                                                +Integer.toBinaryString(dec));
                                    }
                                    case 3 -> {
                                        int dec = Integer.valueOf(num,8);
                                        System.out.println("Corresponding value in Hex Decimal is "
                                                +Integer.toHexString(dec));
                                    }
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    while (true) {
                        System.out.print("""

                                What operation do u want to perform
                                1.Hex Addition\t\t2.Hex Subtraction
                                3.Conversion\t\t4.Back
                                Your choice is:\s""");
                        byte hex_choice = input.nextByte();
                        System.out.println(" ");
                        if (hex_choice == 4) break;
                        switch (hex_choice){
                            case 1 -> {
                                //code for hex addition
                                System.out.print("Enter first hex-decimal number: ");
                                String num1 = input.next();
                                System.out.print("Enter second hex-decimal number: ");
                                String num2 = input.next();
                                int h1 = Integer.valueOf(num1, 16);
                                int h2 = Integer.valueOf(num2, 16);
                                String res = Integer.toHexString((h1+h2));
                                System.out.println("The result is "+res);
                            }
                            case 2 -> {
                                // code for hex subtraction
                                System.out.print("Enter first hex-decimal number: ");
                                String num1 = input.next();
                                System.out.print("Enter second hex-decimal number: ");
                                String num2 = input.next();
                                int h1 = Integer.valueOf(num1, 16);
                                int h2 = Integer.valueOf(num2, 16);
                                String res = Integer.toHexString((h1+(~h2+1)));
                                System.out.println("The result is "+res);
                            }
                            case 3 -> {
                                //code for conversion
                                System.out.print("""
                                        Convert To
                                        1.Decimal\t\t2.Binary
                                        3.Octal\t\t\t4.Back
                                        Your Choice:\s""");
                                byte con_choice = input.nextByte();
                                if (con_choice == 4) break;
                                System.out.print("Enter the number in Hex Decimal: ");
                                String num = input.next();

                                switch (con_choice) {
                                    case 1 -> System.out.println("Corresponding number in decimal is"
                                            + Integer.valueOf(num, 16));
                                    case 2 -> {
                                        int dec = Integer.valueOf(num, 16);
                                        System.out.println("Corresponding value in Binary is "
                                                + Integer.toBinaryString(dec));
                                    }
                                    case 3 -> {
                                        int dec = Integer.valueOf(num, 16);
                                        System.out.println("Corresponding value in Octal is "
                                                + Integer.toOctalString(dec));
                                    }
                                }
                            }
                        }
                    }
                }
                default -> System.out.println("You entered invalid choice.");
            }
        }
    }

}
