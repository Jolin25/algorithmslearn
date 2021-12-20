package top.algorithms.learn.others;

import java.util.HashMap;
import java.util.Map;
/**
 * 第二阶段是链接（Linking），这是核心的步骤，简单说是把原始的类定义信息平滑地转化入 JVM 运行的过程中。
 * 这里可进一步细分为三个步骤：
 * 验证（Verification），这是虚拟机安全的重要保障，
 * JVM 需要核验字节信息是符合 Java 虚拟机规范的，否则就被认为是 VerifyError，这样就防止了恶意信息或者不合规的信息危害 JVM 的运行，验证阶段有可能触发更多 class 的加载。
 * 准备（Preparation），
 * 创建类或接口中的静态变量，并初始化静态变量的初始值。但这里的“初始化”和下面的显式初始化阶段是有区别的，侧重点在于分配所需要的内存空间，不会去执行更进一步的 JVM 指令。
 * 解析（Resolution），
 * 在这一步会将常量池中的符号引用（symbolic reference）替换为直接引用。在Java 虚拟机规范中，详细介绍了类、接口、方法和字段等各个方面的解析。
 * <p>
 * <p>
 * 第三阶段是初始化阶段（initialization），
 * 这一步真正去执行类初始化的代码逻辑，
 * 包括静态字段赋值的动作，以及执行类定义中的静态初始化块内的逻辑，编译器在编译阶段就会把这部分逻辑整理好，父类型的初始化逻辑优先于当前类型的逻辑。
 *
 * @author jrl
 * @date 2021-9-10
 */

/**
 * todo 为了探索类加载的时候干了什么
 *
 * @author jrl
 * @date 2021-9-10
 */
public class ClassTest {

    /**
     * 静态成员变量
     */
    static int staticFieldOne = 1;
    /**
     * 成员变量
     */
    int fieldOne = 2;

    /**
     * 静态成员常量
     */
    static final int STATIC_FINAL_FIELD_ONE = 3;
    /**
     * 成员常量
     */
    final int FINAL_ONE = 4;

    {
        System.out.println("hello world in block");
        System.out.println("staticFieldOne in block is（before change） :" + staticFieldOne);
        System.out.println("fieldOne in block is（before change） :" + fieldOne);
        int blockField = 5;
        staticFieldOne = 11;
        fieldOne = 22;
        System.out.println("staticFieldOne in block is（after change） :" + staticFieldOne);
        System.out.println("fieldOne in block is （after change）:" + fieldOne);
    }

    static {
        System.out.println("hello world in static block");
        System.out.println("staticFieldOne in block is（before change） :" + staticFieldOne);
        int staticBlockField = 6;
        staticFieldOne = 111;
        System.out.println("staticFieldOne in block is （after change） :" + staticFieldOne);
    }

    public static void main(String[] args) {
        // todo 为了知道在链接-->解析 这一步，把常量池中的符号引用替换为直接引用
        Map map = new HashMap<>(5);
    }
}
