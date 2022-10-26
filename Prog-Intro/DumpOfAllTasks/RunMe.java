//import java.math.BigInteger;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
///**
// * Run this code with provided arguments.
// *
// * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
// */
//public class RunMe {
//
//    public static void main(final String[] args) {
//        final byte[] password = parseArgs(args);
//
//
//        key0(password);
//        System.out.println("The first key was low-hanging fruit, can you find others?");
//        System.out.println("Try to read, understand and modify code in keyX(...) functions");
//
//
//
//
//        key5(password);
//
//    }
//
//    private static void key0(final byte[] password) {
//        // The result of print(...) function depends only on explicit arguments
//        print(0, 0, password);
//    }
//
//
//    private static void key1(final byte[] password) {
//        while ("1".length() == 1) {
//            break;
//        }
//
//        print(1, 5704387504387508453L, password);
//    }
//
//
//    private static void key2(final byte[] password) {
//        int result = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    result ^= (i * 7) | (j + k);
//                    result ^= result << 1;
//                }
//            }
//        }
//
//        print(2, 4875439857928435451L, password);
//    }
//
//
//    private static void key3(final byte[] password) {
//        int result = 0;
//        for (int i = 0; i < 2021; i++) {
//            for (int j = 0; j < 2021; j++) {
//                for (int k = 0; k < 2021; k++) {
//                    for (int p = 0; p < 3; p++) {
//                        result ^= (i * 5) | (j * 7 + k) & ~p;
//                        result ^= result << 1;
//                    }
//                }
//            }
//        }
//
//        print(3, result, password);
//    }
//
//
//    private static void key4(final byte[] password) {
//        for (long i = 5740487519460015566L; i < 9223372036854775807L; i++) {
//            if ((i ^ (i >>> 32)) == 5740487520438743858L) {
//                print(4, i, password);
//            }
//        }
//    }
//
//
//    private static final long PRIME = 1073741783;
//
//    private static void key5(final byte[] password) {
//        final long n = 1000_000_000_000_000L + ByteBuffer.wrap(password).getInt();
//
//        BigInteger x = BigInteger.valueOf(n/60L);
//        BigInteger x2 = x.multiply(x), x43 = x.multiply(BigInteger.valueOf(43L));
//        BigInteger x2_2310 = x2.multiply(BigInteger.valueOf(2310L));
//        BigInteger result = x2_2310.subtract(x43);
//        result = result.mod(BigInteger.valueOf(PRIME));
//        BigInteger maxy = BigInteger.valueOf(n);
//        long maximum = maxy.subtract(x.multiply(BigInteger.valueOf(60L))).longValue(), res = result.longValue();
//        for (long i = n - maximum+1; i < n; ++i)
//        res = (res + i/2 + i/3 + i/4 + i/5)%PRIME;
//
//        print(5, res, password);
//    }
//
//
//    private static void key6(final byte[] password) {
//        long result = 24857045234L + password[5];
//        print(6, result, password);
//    }
//
//
//    private static void key7(final byte[] password) {
//        // Count the number of occurrences of the most frequent noun at the following page:
//        // https://docs.oracle.com/javase/specs/jls/se11/html/jls-4.html
//        final int result = 592;
//        if (result != 0) {
//            print(7, result, password);
//        }
//    }
//
//
//    private static final String PATTERN = "Читать документацию может быть на удивление полезно!";
//    private static final int SMALL_REPEAT_COUNT = 10_000_000;
//
//    private static void key8(final byte[] password) {
//        String repeated = "";
//        for (int i = 0; i < 0; i++) {
//            repeated += PATTERN;
//        }
//
//        print(8, PATTERN.repeat(SMALL_REPEAT_COUNT).hashCode(), password);
//    }
//
//
//    private static final long LARGE_REPEAT_SHIFT = 27;
//    private static final long LARGE_REPEAT_COUNT = 1L << LARGE_REPEAT_SHIFT;
//
//    private static final long LARGE_REPEAT_SHIFT = 27;
//    private static final long LARGE_REPEAT_COUNT = 1L << LARGE_REPEAT_SHIFT;
//
//    private static void key9(final byte[] password) {
//        String repeated = "";
//        for (long i = 0; i < LARGE_REPEAT_COUNT; i++) {
//            repeated += PATTERN;
//        }
//
//        print(9, repeated.hashCode(), password);
//    }
//
//
//    private static void key10(final byte[] password) {
//        print(10, 4508604576084534553L, password);
//    }
//
//
//    private static void key11(final byte[] password) {
//        final BigInteger year = BigInteger.valueOf(-2021);
//        final BigInteger prime = BigInteger.valueOf(PRIME);
//
//        final long result = Stream.iterate(BigInteger.ZERO, BigInteger.ONE::add)
//                .filter(i -> year.multiply(i).add(prime).multiply(i).compareTo(BigInteger.ZERO) > 0)
//                .mapToLong(i -> i.longValue() * password[i.intValue() % password.length])
//                .sum();
//
//        print(11, result, password);
//    }
//
//
//    private static final long MAX_DEPTH = 100_000_000L;
//
//    private static void key12(final byte[] password) {
//        try {
//            key12(password, 0, 0);
//        } catch (final StackOverflowError e) {
//            System.err.println("Stack overflow :((");
//        }
//    }
//
//    private static final long MAX_DEPTH = 100_000_000L;
//    private static void key12(final byte[] password) {
//        long result = 0;
//        for (long i = 0; i < MAX_DEPTH; i++) {
//            result = (result ^ 857032297) + i * 13;
//        }
//        try {
//            print(12, result, password);
//        } catch (final StackOverflowError e) {
//            System.err.println("Stack overflow :((");
//        }
//    }
//
//    private static void key12(final byte[] password, final long depth, final long result) {
//        if (depth < MAX_DEPTH) {
//            System.out.println((result ^ 857032297) + depth * 13);
//
//            key12(password, depth + 1, (result ^ 857032297) + depth * 13);
//        } else {
//            print(12, result, password);
//        }
//    }
//
//    private static void key13(final byte[] password) {
//        // Sept, 8th is the 251th day of the year
//        final BigInteger secondsInFullTurn = BigInteger.valueOf(2021 * 365 + 251);
//
//        final long result = Stream.iterate(BigInteger.ZERO, BigInteger.ONE::add)
//                .map(secondsInFullTurn::multiply)
//                .reduce(BigInteger.ZERO, BigInteger::add)
//                .longValue();
//
//        print(13, result, password);
//    }
//
//    private static void key14(final byte[] password) {
//        print(14, 4545325321343434153L + password[3], password);
//    }
//
//    private static void key15(final byte[] password) {
//        byte a1 = (byte) (password[0] + password[3]);
//        byte a2 = (byte) (password[1] + password[4]);
//        byte a3 = (byte) (password[2] + password[5]);
//
//        for (long i = 1000_000_000_000_000L + ByteBuffer.wrap(password).getInt(); i >= 0; i--) {
//            a1 ^= a2;
//            a2 += a3 & a1;
//            a3 -= a1;
//        }
//
//        final String result = a1 + " " + a2 + " " + a3;
//        print(15, result.hashCode(), password);
//    }
//
//    private static void key16(final byte[] password) {
//        print(16, calc16(Math.abs(Arrays.toString(password).hashCode() % 2021)), password);
//    }
//
//    /**
//     * Write me
//     * <pre>
//     *    0: iconst_0
//     *    1: istore_1
//     *    2: iload_1
//     *    3: bipush        39
//     *    5: idiv
//     *    6: iload_0
//     *    7: isub
//     *    8: ifge          17
//     *   11: iinc          1, 1
//     *   14: goto          2
//     *   17: iload_1
//     *   18: ireturn
//     * </pre>
//     */
//    private static int calc16(final int n) {
//        return n;
//    }
//
//    // ---------------------------------------------------------------------------------------------------------------
//    // You may ignore all code below this line.
//    // It is not required to get any of the keys.
//    // ---------------------------------------------------------------------------------------------------------------
//
//    private static void print(final int no, long result, final byte[] password) {
//        final byte[] key = password.clone();
//        for (int i = 0; i < 6; i++) {
//            key[i] ^= result;
//            result >>>= 8;
//        }
//
//        System.out.format("Key %d: https://www.kgeorgiy.info/courses/prog-intro/hw1/%s%n", no, key(key));
//    }
//
//    private static String key(final byte[] data) {
//        DIGEST.update(SALT);
//        DIGEST.update(data);
//        DIGEST.update(SALT);
//        final byte[] digest = DIGEST.digest();
//
//        final StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 6; i++) {
//            if (i != 0) {
//                sb.append("-");
//            }
//            sb.append(KEYWORDS.get(digest[i] & 63));
//        }
//        return sb.toString();
//    }
//
//    private static byte[] parseArgs(final String[] args) {
//        if (args.length != 6) {
//            throw error("Expected 6 command line arguments, found: %d", args.length);
//        }
//
//        final byte[] bytes = new byte[args.length];
//        for (int i = 0; i < args.length; i++) {
//            final Byte value = VALUES.get(args[i].toLowerCase());
//            if (value == null) {
//                throw error("Expected keyword, found: %s", args[i]);
//            }
//            bytes[i] = value;
//        }
//        return bytes;
//    }
//
//    private static AssertionError error(final String format, final Object... args) {
//        System.err.format(format, args);
//        System.err.println();
//        System.exit(1);
//        throw new AssertionError();
//    }
//
//    private static final MessageDigest DIGEST;
//    static {
//        try {
//            DIGEST = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            throw new AssertionError("Cannot create SHA-256 digest", e);
//        }
//    }
//
//    private static final byte[] SALT = "divAcVuetDerrogWaph7ugLarbyianAvDapquev2Tholyat8KoakGenMysby".getBytes(StandardCharsets.UTF_8);
//
//    private static final List<String> KEYWORDS = List.of(
//            "abstract",
//            "assert",
//            "boolean",
//            "break",
//            "byte",
//            "case",
//            "catch",
//            "char",
//            "class",
//            "const",
//            "continue",
//            "default",
//            "do",
//            "double",
//            "else",
//            "enum",
//            "extends",
//            "false",
//            "final",
//            "finally",
//            "float",
//            "for",
//            "goto",
//            "if",
//            "implements",
//            "import",
//            "instanceof",
//            "int",
//            "interface",
//            "long",
//            "native",
//            "new",
//            "null",
//            "package",
//            "private",
//            "protected",
//            "public",
//            "return",
//            "short",
//            "static",
//            "strictfp",
//            "super",
//            "switch",
//            "synchronized",
//            "this",
//            "throw",
//            "throws",
//            "transient",
//            "true",
//            "try",
//            "var",
//            "void",
//            "volatile",
//            "while",
//            "Exception",
//            "Error",
//            "Object",
//            "Number",
//            "Integer",
//            "Character",
//            "String",
//            "Math",
//            "Runtime",
//            "Throwable"
//    );
//
//    private static final Map<String, Byte> VALUES = IntStream.range(0, KEYWORDS.size())
//            .boxed()
//            .collect(Collectors.toMap(index -> KEYWORDS.get(index).toLowerCase(), Integer::byteValue));
//}
