# 2.AAG-Literals
Listing 2 AAG-Literals/Literals.java Page 13

# Section 3. Types, variables, literals  

## 3.1    Primitive types  

Any piece of data must have a **type**. In Java, the types that may correspond to named variables are called **primitive** (or fundamental) types. We may think of a **variable** of a primitive type as of a named piece of memory containing a single value of a well defined type. The type of a variable determines its length (number of bytes it occupies) and the way its contents is interpreted. In Java, only variables of primitive types can be created locally, on the stack — objects of all other types can only be created on the heap (free memory) and never have names (identifiers). We will explain what stack and heap are shortly.  

### 3.1.1    Names  

We have just mentioned that only variables of primitive types can have names (identifiers). So let’s say a few words about them. Identifiers in Java may be of any length and may consist only of

* Letters. These can be lower- or upper-case letters, but remember that upper-and lower-case letters are considered different: ’a’ and ’A’ are not equivalent. In principle, all letters, in any language, can be used, but it’s recommended to stick to Latin letters only.

* Digits. They cannot appear at the beginning of any identifier. As with letters, any characters considered to be digits in UNICODE system may be used, but in practice we use only Arabic digits (0,..., 9).

* Underscore character (’\_’).

* Currency symbols (like $). Just do not use them (they are used internally by the compiler).

There are several conventions concerning identifiers which are generally accepted and should always be followed:

* Only the names of classes and interfaces should start with a capital letter.

* If a name consists of several words, the first letter of each internal word should be capitalized (the so called _camel-case notation_). For example, `getWidth`, `setCurrentRate`, etc.

* The names of variables declared as constants should be all uppercase with words separated by underscores (e.g. `MIN\_WIDTH`).

More information about coding convention used in Java can be found at the official Oracle’s web pag[e](#bookmark4)[1](#bookmark5).

Some names are used in Java as the so called **keywords**. They have special meaning in the language itself (and do not correspond to any variables or classes). These names are reserved and cannot be used as identifiers of anything

**Table 1** Java keywords  

![](https://github.com/Java-PJATK/02.AAG-Literals/blob/main/images/JavaKeywords.PNG?raw=true)

|  &nbsp;    |   &nbsp;   | &nbsp;     | &nbsp;     | &nbsp;     |
|------------|------------|------------|------------|------------|
| abstract   | continue   | for        | new        | switch     |
| assert     | default    | goto       | package    | synchronized |
| boolean    | do         | if         | private    | this       |
| break      | double     | implements | protected  | throw      |
| byte       | else       | import     | public     | throws     |
| case       | enum       | instanceof | return     | transient  |
| catch      | extends    | int        | short      | try        |
| char       | final      | interface  | static     | void       |
| class      | finally    | long       | strictfp   | volatile   |
| const      | float      | native     | super      | while      |

The keywords const and goto are not used, but reserved. Moreover, there are three names which formally are not keywords (they are literals) but that nevertheless cannot be used as names of anything: these are true, false and null.

### 3.1.2 Overview of primitive types

The primitive types are (number of bytes is given in parentheses):

* Numerical types:

—    integral types correspond to integer (whole) numbers. Their possible values belong to interval \[—2<sup>N-1</sup>, 2<sup>N-1</sup>— 1\], where N is the number of bits (one byte = 8 bits). The exception is char whose values are always interpreted as non-negative and belong to interval \[0, 2<sup>16</sup> — 1\].

* `byte` (1) — values in range \[—128,127\];

* `short` (2) — values in range \[—32 768, 32 767\];

* `char` (2) — values in range \[0, 65 535\] interpreted as Unicode code points of characters (always non-negative);

* `int` (4) —values in range \[—2147483 648, 2147483 647\];

* `long` (8) — values in an astronomical range \[—9 223 372 036 854 775 808, 9 223 372 036 854 775 807\].

—    floating point types correspond to real numbers (with fractional parts). There are two such types with different ranges and precision.

\* `float` (4) — values in range \[≈ 1.4 ∙ 10<sup>-45</sup>, ≈3.4 ∙ 10<sup>+38</sup>\] positive or negative, with roughly 7 significant decimal digits - rarely used;

\* `double` (8) — values in range \[≈ 4.9 ∙ 10 <sup>-324</sup>, ≈ 1.8 ∙ 10<sup>+308</sup>\] positive or negative, with roughly 16 significant decimal digits.

* Logical type `boolean` — has only two possible values: true and false. They are not convertible to numerical values, neither are numerical values convertible to boolean (as they are in many other languages);

* References to objects: — variables of these types hold as their values _addresses_ of objects (of the so called object types, there are no references to variables of primitive types in Java). In C/C++ such variables are called **pointers**. \[Note that C++ also uses references, but they do not have much in common with what we call references in Java.\]

### 3.1.3 Integral types

Let us explain how integral values are represented in computer’s memory. Consider a byte: it contains 8 bits, so we can represent it by a sequence of eight digits, each of which is 0 or 1:

&nbsp;&nbsp;&nbsp;&nbsp;b<sub>7</sub>b<sub>6</sub>b<sub>5</sub>b<sub>4</sub>b<sub>3</sub>b<sub>2</sub>b<sub>1</sub>b<sub>0</sub>

This can be interpreted as a number in the binary system, so consecutive digits (from the right) are coefficients at consecutive powers of 2. There is a quirk, however: in order to be able to represent also negative numbers, the term with the highest power of 2 is taken with negative sign

&nbsp;&nbsp;&nbsp;&nbsp;\-b<sub>7</sub> ∙ 2<sup>7</sup> + b<sub>6</sub> ∙ 2<sup>6</sup> + b<sub>5</sub> ∙ 2<sup>5</sup> + b<sub>4</sub> ∙ 2<sup>4</sup> + b<sub>3</sub> ∙ 2<sup>3</sup> + b<sub>2</sub> ∙ 2<sup>2</sup> + b<sub>1</sub> ∙ 2<sup>1</sup> + b<sub>0</sub> ∙ 2<sup>0</sup> 

Therefore, to get the highest possible value of a byte, we should set this negative part to zero, and all remaining terms with coefficient 1 — for numbers represented by one byte it would be  

&nbsp;&nbsp;&nbsp;&nbsp;01111111  

which is 127<sub>10</sub>. Expressing groups of four bits as hexadecimal digits (see below) the same number is 7F. The smallest (negative) `byte` will have 1 at the negative part and all zeros at the positive ones

&nbsp;&nbsp;&nbsp;&nbsp;10000000  

what in hexadecimal notation would be -80 (it corresponds to —128<sub>10</sub>). This reasoning applies to the remaining integral types, except `char` — here we count all terms (char in Java is 16 bits long) with plus sign.

There are special operators that operate on integers treating them not as numbers but rather as sequences of bits which can convey some information (not necessarily numerical). We will show these operators in Sec. [5.1.4](#bookmark10) on page [25](#bookmark10). For now just few examples.

If we have two integer numbers (we will use only eight-bit numbers for simplicity), we can AND them: the result will be a sequence of bits where there is 1 whenever there is 1 in both numbers at the corresponding position, and 0 otherwise — we can interpret it as the logical conjunction bit-by-bit with 1 corresponding to true and 0 to false:

```
0 1 1 0 1 1 0 0
0 1 0 1 0 1 0 1
---------------
&
0 1 0 0 0 1 0 0
```

The symbol of AND is ’&’, so interpreting these sequences of bits as numbers, we get 108 & 85 = 68.

Similarly, ORing corresponds to alternative, or logical disjunction (denoted by a vertical bar) — to be true, at least one operand must be true:

```
0 1 1 0 1 1 0 0
0 1 0 1 0 1 0 1
---------------
|
0 1 1 1 1 1 0 1
```

what corresponds to 108 | 85 = 125.

Another operation is XORing (exclusive or), denoted by ’"’. Here we get true only if two operands are _different_:

```
0 1 1 0 1 1 0 0
0 1 0 1 0 1 0 1
---------------
^
0 0 1 1 1 0 0 1
```

or 108<sup>^</sup> 85 = 57. XORing has several interesting (and useful) features. For example, let’s consider XORing a number with 1’s:

```
0 1 1 0 1 1 0 0
1 1 1 1 1 1 1 1
---------------
^
1 0 0 1 0 0 1 1
```

As we can see, the result is like the original value, but with all bits flipped: 0 → 1, 1 → 0. Now let’s XOR the same number with 0’s:

```
0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0
---------------
^
0 1 1 0 1 1 0 0
```

Now the original number has been exactly reproduced. So, XORing with 1 flips the bit, XORing with 0 - leaves it intact. It follows, that XORing any bit with the same bit-value (whether it’s 0 or 1) _twice_ always reproduces the original value:

```
0 1 1 0 1 1 0 0
0 1 0 1 0 1 0 1
---------------
^
0 0 1 1 1 0 0 1
```

and we XOR the result again with 01010101:   

```
0 0 1 1 1 0 0 1
0 1 0 1 0 1 0 1
---------------
^
0 1 1 0 1 1 0 0
```

what reproduces the original sequence of bits 01101100.  

Negation (NOT, symbol '~') of a sequence of bits yields the same sequence but with all bits reversed (flipped):

```
~ 0 1 1 0 1 1 0 0    ->    1 0 0 1 0 0 1 1
```

Other useful operations on sequences of bits are shifts — to the left or to the right by a given number of bits. When we shift bits to the left (symbol `<<`), all bits coming out on the left edge just disappear and zeros come in from the right side:

```
0 1 1 0 1 1 0 0 << 2    ->    1 0 1 1 0 0 0 0
```

while the opposite holds for right shift (`>>>`):

```
0 1 1 0 1 1 0 0 >>> 2    ->    0 0 0 1 1 0 1 1
```

There is also >> operator — here, what comes in from the left is the value of the highest (leftmost) bit: if that is 0 (was corresponds to positive numbers), then zeros come in while if its is 1 (negative numbers), then ones will come in. More details can be found in Section [5.1.4](#bookmark10) on p. [25](#bookmark10).

### 3.1.4 Floating point types

The representation of floating point numbers (that represent real [](#bookmark14)[2](#bookmark15) numbers known from mathematics) is completely different. Let us consider float (although it is not much used). Numbers of this type are stored in 4 bytes, i.e., 32 bits. The highest bit is just the sign bit: 0 for positive values, 1 for negative. Then we have eight bits of the so called exponent, and 23 bits of the mantissa

`seeeeeeeefffffffffffffffffffffff`

Eight bits of the exponent are collectively denoted by E and described by the number from the range \[0, 255\] that these eight bit represent in the binary system. The 23 bits of the mantissa are denoted collectively as F. Then the value is

_V_ = (−1)<sup>s</sup> × 2<sup>E−127</sup> × 1._F_

The 127 (the so called bias) is needed, because otherwise it would be impossible to represent numbers smaller than one. The first significant digit of any number expressed in binary system must be 1, so this 1 is implicitly added at the beginning, before the binary dot, and is followed by 23 bits of the mantissa. Consequently, we have not 23, but 24 significant binary digits, what corresponds to precision of 24/log<sub>2</sub>10 ≈ 7.2 decimal digits.

For example, in

`00111110001000000000000000000000`

we have s = 0 , E = 01111100<sub>2</sub>  = 124<sub>10</sub> , F = 01000000000000000000000, so  

V = (−1)0 × 2<sup>124−127</sup> × 1.01<sub>2</sub>  

which, in decimal system, is  
 
1.25 · 2<sup>−3 </sup>= 5/8 · 4 = 5/32 = 0.15625  

If E = 255 (all ones in binary system), then the interpretation is special: if also F = 0, then the number represents ±∞ (depending on sign bit). If F ≠ 0 however, then it is a NaN (not-a-number — this will be the result, for example, of taking the logarithm or the square root of a negative number).  

Numbers with E = 0 are also treated differently (these are the called _subnormal numbers_):  

V = (-1)<sup>s</sup> × 2<sup>E-126</sup> × 0.F  

As there is no implicit 1 added before the mantissa part, such numbers may have fewer significant digits, so their precision is worse than that of ’normal’ numbers.  

The basic floating point type is double, though, not float. It occupies 8 bytes (64 bits): the sign bit, 11 bits of the exponent, 52 bits of mantissa. The bias is 1023. Adding the implicit 1, we have 53 significant binary digits, what corresponds to precision of 53/ log<sub>2</sub>10 ≈ 16 decimal digits.  

## 3.2 Object types

Besides primitive types, there are also the so called **object types**. They are defined by the user, although many such types are already defined by implementers of the standard library and we can use them in our programs. Names of object types should always start with an upper case letter (it’s not enforced by the compiler, but is a convention we should always observe).  

Objects of these types (variables) cannot be created locally on the stack and never have names. They are created on the heap and can be automatically removed from memory when not needed anymore. We have access to such objects only through references (pointers) to them which physically contain only their addresses, not values. There is a special process, called **garbage collector**, which detects object on the heap which are not referenced anymore by any reference variable in the program and removes these unnecessary objects from memory. Object types are defined by `classes` which we will cover in the following chapters. Generally, they describe objects more complicated than just a single value: the object may contain several numbers, Boolean values, and references (addresses) to other objects (e.g., of type `String`); moreover, the class also defines operations that may act upon all this data.  

Let us emphasize again that a variable (called _object_) of an object type is _always_ anonymous — there is no way to give it any name. Only variables of reference types (pointers), which hold _addresses_ of objects as their values, may have names (identifiers).  

## 3.3 Variables and literals  

**Variable** may be understood as a named region of memory storing a value of a specified type. Each variable, before it can be used, has to be created (declared and defined) — in declaration we specify its name and type. It is also recommended to assign a value to any newly created variable (initialize it). Java compiler will not allow us to refer to the value of a variable until it can see an assignment of a value to this variable. When assigning a value to a variable, we can use the value of any expression yielding a value of an appropriate type; in the simplest case this may be just a value specified literally. A number written without a decimal dot is understood to be of type `int`.  

```
int    a    =    7;
int    b    =    a +    5;
```

For local variables, instead of declaring a type explicitly, one can use a special keyword var: then the compiler will figure out the type itself. Of course, we have to give it a chance to do so, so the variable being defined must be initialised. For example, the definitions above could have been written as

```
var    a    =    7;
var    b    =    a +    5;
```

because the initialisers on the right tell the compiler that a and b should be of type `int`.

We can add a letter ’L’ (or lower-case ’l’, but that could be easily confused with digit 1) at the and if we want the compiler to treat it as a `long`

```
long m = 101L, n = 2147483648L;
```

(note that 2147483648 without the ’L’, would be treated as an `int`, but that would be wrong, because it is too big for an `int`!). Literal integers may also be written in octal (0 at the beginning), hexadecimal (0x at the beginning) or binary (0b at the beginning) form:

```
int a = 189, b = 0275, c = 0xBD, d = 0b10111101;
```

Variables a, b, c and d all have the same value 189<sub>10</sub>, because (taking digits from right to left)

189 = 9 · 10<sup>0</sup> + 8 · 10<sup>1</sup> + 1 · 10<sup>2</sup> = 9 + 80 + 100 = 189

0275 = 5 · 8<sup>0</sup> + 7 · 8<sup>1</sup> + 2 · 8<sup>2</sup> = 5 + 56 + 128 = 189

0xBD = 13 · 16<sup>0</sup> + 11 · 16<sup>1</sup> = 13 + 176 = 189

0b10111101 = 1 · 2<sup>0</sup> + 0 · 2<sup>1</sup> + 1 · 2<sup>2</sup> + 1 · 2<sup>3</sup> + 1 · 2<sup>4</sup> + 1 · 2<sup>5</sup> + 0 · 2<sup>6</sup> + 1 · 2<sup>7</sup> =
1 + 4 + 8 + 16 + 32 + 128 = 189

Hexadecimal notation is especially convenient, because there are 16 hexadecimal digits (0-9, A-F) and exactly 16 possible values of any four-bit group of bits. Therefore, one byte can always be described by two hexadecimal digits and _vice versa_ — any two hexadecimal digits describe uniquely one byte. For example, the greatest short has representation

`0111 1111 1111 1111`

(see above) which is 0b0111111111111111 or 0x7FFF, while the smallest

`1000 0000 0000 0000`

which is 0b1000000000000000 or 0x8000. When writing such literal values, leading zeros may be omitted: instead of 0b0000000000101010, one can write just 0b101010. Additionally, you can insert underscores between digits: they will be ignored by the compiler, but improve readability. The number 1\_123\_343\_198 is much easier to read than 1123343198.

A number written literally, but with a decimal point is understood to be a `double`  

```
double x = 1.5;
double y = x + 0.75;
```

or

```
var x = 1.5;
var y = x + 0.75
```

We can add a letter ’F’ (or ’f’) at the end if we want the compiler to treat a literal as a float

`float x = 1.5F;`

Floating point numbers can also be written in the so called scientific notation. In this notation we have a number (possibly with a decimal dot), then the letter ’E’ (lower- or uppercase) and then a integral number indicating the power of 10. For example 1.25E2 means 1.25 ⋅ 10<sup>2</sup> (i.e., 125), while 1E-7 means 1 ⋅ 10<sup>-7</sup> (0.0000001).

Literal of type char may be written as a single character in apostrophes

`char c = 'A';`

As char is a numerical type, the value will be a number, namely the Unicode code of a given character (which for ’A’ is 65). As char occupies two bytes and is treated as a non-negative number, its values are in the range \[0, 2<sup>16</sup> — 1\] = \[0,65 535\] which is enough for all letters (and other symbols) in almost all languages to be represented. Characters that are not present on our keyboard may be entered like this

`char c = '\\u03B1';`

by writing, after a backslash and letter ’u’, the Unicode code of a character in hexadecimal notation. In this case, the code 0x03B1 corresponds to the Greek letter a. There are also some special characters that cannot be entered from the keyboard, like CR (carriage return), LF (line feed), etc. They can be specified using the Unicode notation, as above, but they also correspond to special symbols: a backslash and a letter or another symbol

* \\a - (BEL) alert;  

* \\b - (BS) backspace;  

* \\f - (FF) form-feed (new page);  

* \\n - (LF) new line (linefeed);  

* \\r - (CR) carriage return;  

* \\t - (HT) horizontal tab;  

* \\v- (VT) vertical tab;  

* \\’ - apostrophe;  

* \\" \- quotation mark;  

* \\\\ - backslash;  

Some examples of literals can be found in the program below:  

## Listing 2 AAG-Literals/Literals.java  

```java
public class Literals {
    public static void main(String[] args) {
        System.out.println(22);         // decimal
        System.out.println(022);        // octal
        System.out.println(0x22);       // hexadecimal
        System.out.println(0b1001);     // binary
        System.out.println(22.22);      // double
        System.out.println(2.22e-1);    // "scientific"
        System.out.println(1/3 );       // this is 0 !
        System.out.println(1/3.);       // one third
        System.out.println(1/3D);       // 3D -> double
        System.out.println(2147483648L);// long
        System.out.println(2147483647  + 1 ); // ooops!
        System.out.println(2147483647L + 1 );
        System.out.println('A');        // char
        System.out.println('A'+2);      // char
        System.out.println((char)('A'+2));
        System.out.println('\u0042');   // also char
        System.out.println("Hello, World");
        System.out.println("\u017b\u00F3\u0142w");
        System.out.println("number = " +  2+2);
        System.out.println("number = " + (2+2));
        System.out.println(false);
        System.out.println(2*3 == 6);
        System.out.println("\"TAB\"s and 'NL'\n"+
                           "a\tb\tc\te\tf\n\tg\th\ti\tj");
        System.out.println("C:\\Program Files\\java");
    }
}


```

which prints  

```
22
18
34
9
22.22
0.222
0
0.3333333333333333
0.3333333333333333
2147483648
-2147483648
2147483648
A
67
C
B
Hello, World
Żółw
number = 22
number = 4
false
true
"TAB"s and 'NL'
a    b    c    e    f
     g    h    i    j

C:\\Program Files\\java
```


and examples of creating and using variables in the program below:

## Listing 3 AAL-Variables/Variables.java

```java

```

which prints

```
k=1, m = 2, n = 4
Sum by 4 is equal to 1
John and Mary
Mary and Mary
```

Note that variables john and mary are _not_ objects of type `String` — they are references (pointers) whose values are _addresses_ of such objects! Therefore, `john=mary` means that we copy the address of the object corresponding to "`Mary`" to the variable `john`; from now on both `john` and `mary` refer to exactly the same object somewhere in memory. Object which was before referred to by the variable `john` is now lost (because we have lost its address) and can be garbage collected.

## 3.4 Conversions  

Sometimes a value of one type should be used as a value of another type. Creating a value of one type based on a value of another type is called **conversion** or **casting**. Of course, it is impossible to change the type of a variable: conversions always involve _values_. For example, in

```java
int a = 7; 
double x = a + 1;
```

the value of the right-hand side in the second line is of type `int` and a `double` is needed to initialize the variable x; however, the compiler will silently convert `int` value to the corresponding `double` value and assign it to x. Such conversions, performed automatically by the compiler, are called **implicit** conversions. Generally, they will be performed if they don't lead to a loss of information. Conversion in the opposite direction

```java
double x = 7.7;
int    a = x; // WRONG
```  

will _not_ be performed; the snippet above wouldn't be even compiled. This is because an `int` occupies four bytes and has no fractional part, while `double`s have fractional part and occupy eight bytes. Hence, conversion from `double` to `int` would lead to inevitable loss of information. We can, however, enforce the compiler to perform such conversions (taking the responsibility for possible consequences). We do it by specifying, in parentheses, name of the type we want to convert to:

```java
double x = 7.7;
int    a = (int)x;  // now OK

```

Of course, after conversion, a will be exactly 7, as there is no way for an `int` to have a fractional part.

Note also that this conversion does _not_ affect the variable x as such: its type is still `double` and its value is still 7.7.

The exact rules of conversions are more complicated, but general principle is that conversions from “narrow” types to “wider” are performed implicitly (`byte`,`char`,`short`→`int`,`int`,`float`,`long`→`double`, etc.), while conversions in the opposite direction must be explicit.

## 3.5 The stack and the heap

Let us briefly explain what the stack and the heap are.

Both are parts of memory that are available to the program at runtime. The stack is simpler: when a new value (e.g., of a variable) is to be added, it is always added at the “top” of the stack. The address of the current “top” of the stack is always available at runtime: actually, there is a special register of the processor dedicated only to store information on the current location of the top of the stack. In particular, no “looking for enough room in memory” is involved.

Whenever we create a new variable inside a block of code (e.g., inside a function), its value is pushed onto the stack. Then every time the flow of control leaves the block (e.g., a function exits), all the variables pushed onto the stack in this block are freed (deleted) in the reverse order as they were pushed, and stack is, as we say, rewound — the top of the stack is again at the position it had before entering the block. This means that all variables declared inside a block are lost forever when we leave it: they are all _local_. The process of removing values from the stack is called “popping off the stack”.

The advantage of using the stack to store variables is that memory is managed for you automatically. We don't have to allocate memory by hand, or free it once we don't need it any more. Also, the CPU organizes stack memory very efficiently: reading from and writing to stack is very fast.

The heap is a region of memory that is _not_ managed automatically. When the program asks the system to store some data on the heap, the system searches for a free space there, writes this data in this location, marks this region as occupied and return its address — this address can be stored in a variable of a reference type (which itself may be on the stack). Note that if the value of this variable is lost, for example, because it was a local variable in a block, the data on the heap it referred to is no longer available, as we have lost its address! In Java, such unavailable object on the heap may be eventually freed automatically by the process of the so called _garbage collector_.

Unlike the stack, variables created on the heap are accessible not only locally, but wherever their address is known. Heap memory is slower to be read from and written to, because one has to use pointers (which contain addresses) and follow them to access memory on the heap. Also, the process of allocating memory on the heap is rather complicated and time consuming.

[1](#footnote1)

[https://www.oracle.com/technetwork/java/codeconventions-150003.pdf](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

[2](#footnote2)

Actually, all numbers representable in the computer memory belong to an “infinitely small” subset of rational numbers, which themselves constitute an “infinitely small” subset of real numbers R.
