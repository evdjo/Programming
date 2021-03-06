package abtract_data_types;


/**
 * This class shows how a recursion can be used to show the number of digits in a given number.
 * 10/02/2014
 *
 * @author Evdzhan Mustafa enm3@aber.ac.uk
 */
public class Recursion {

    public static void main(String[] args) {
        int number = 12;
        System.out.println("The number 12 has : " + digits(number) + " digits.");

        number = 123;
        System.out.println("The number 123 has : " + digits(number) + " digits.");

        number = 1234;
        System.out.println("The number 1234 has : " + digits(number) + " digits.");

        number = 12345;
        System.out.println("The number 12345 has : " + digits(number) + " digits.");

        number = 123456;
        System.out.println("The number 123456 has : " + digits(number) + " digits.");

    }

    static long digits(long number) {
        if (number < 10) {

            return 1;

        } else {

            return 1 + digits(number / 10);

        }
    }

}
