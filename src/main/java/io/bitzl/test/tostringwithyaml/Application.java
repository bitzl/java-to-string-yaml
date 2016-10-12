package io.bitzl.test.tostringwithyaml;


import org.joda.time.DateTime;

import static io.bitzl.test.tostringwithyaml.ToString.fromStringRepresetation;

public class Application {

    private static final int COLUMN_WIDTH = 18;

    public static void main(String[] args) {
        Person person = new Person();
        person.setBirthday(DateTime.parse("1988-01-02"));
        person.setName("Max Müller");
        Book book = new Book();
        book.setAuthor(person);
        book.setPublishedAt(DateTime.parse("2015-10-10"));
        book.setTitle("About Everything");

        System.out.println("Book.toString():");
        System.out.println(book.toString());

        System.out.println();

        int repeats = 10;
        int numberOfIterations = 10000;

        measureThingToString("Book", book, repeats, numberOfIterations);
        measureThingToString("Person", person, repeats, numberOfIterations);

        System.out.println();

        System.out.println("Calling toString() and load again:");
        System.out.println(fromStringRepresetation("!!io.bitzl.test.tostringwithyaml.Book {author: {birthday: !!timestamp '1988-01-02T00:00:00Z',\n" +
                "    name: Max Müller}, publishedAt: !!timestamp '2015-10-09T23:00:00Z', title: About Everything}"));
    }

    private static String format(double duration) {
        String string = String.format("%.1f µs ", duration);
        if (string.length() < COLUMN_WIDTH) {
            int padding = COLUMN_WIDTH - string.length();
            return String.format("%10s", string);
        }
        return null;
    }

    private static void measureThingToString(String info, Object thing, int repeats, int numberOfIterations) {
        System.out.print(info + "\t");
        for (int k=0; k < repeats; k++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < numberOfIterations; i++) {
                thing.toString();
            }
            double duration = 1.0 * (System.currentTimeMillis() - start) / numberOfIterations * 1000;
            System.out.print(format(duration));
        }
        System.out.println();
    }

}
