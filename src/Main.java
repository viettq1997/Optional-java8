import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // gán giá trị cho hello. Optional.of không cho phép truyền vào giá trị null
        // Optional<String> hello = Optional.of("hello");

        Optional<String> hello = Optional.ofNullable("ab");

        // hello != null -> hello.isPresent() = true
        System.out.println(hello.isPresent());

        // hello == null -> hello.isEmpty() = true
        System.out.println(hello.isEmpty());

        // orElse : nếu hello == null -> hello = world
        String orElse = hello.orElse("world orElse");
        System.out.println(orElse);
        // -> sout: world (if hello == null)

        /**
         * if hello == null -> thuc hien map
         * if else -> thực hiện arrow function trong orElseGet()
         * */
        String orElse2 = hello
                .map(s -> {
                    System.out.println(s);
                    return s;
                })
                .orElseGet(() -> {
                            System.out.println(hello);
                            return "world orElseGet";
                        }
                );
        System.out.println(orElse2);

        hello.ifPresent(s -> {
            s = s + "toi";
            System.out.println("toi" + s);
                });
        System.out.println(hello);
        hello.ifPresentOrElse(s -> {
            System.out.println(s);
        }, () -> {
            System.out.println("world ifPresentOrElse");
        });
    }
}


