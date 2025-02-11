package rsa_project;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA_project {
//    private BigInteger ulp;
//    private BigInteger ulq; 

    public BigInteger n;
    private BigInteger m;
    public BigInteger e;

    private BigInteger d; //public double c;

    static boolean checkForPrime(BigInteger i) {
        boolean isltPrime = true;
        if (i.compareTo(BigInteger.ONE) <= 0) {
            isltPrime = false;
            return isltPrime;
        } else {
            for (BigInteger j = BigInteger.valueOf(2);
                    j.compareTo(i.divide(BigInteger.TWO)) <= 0;
                    j = j.add(BigInteger.ONE)) {
                if (i.mod(j).equals(BigInteger.ZERO)) {
                    isltPrime = false;

                    break;
                }
            }
            return isltPrime;
        }
    }

    public BigInteger sumN(BigInteger p, BigInteger q) {
        n = p.multiply(q);
        return n;
    }

    public BigInteger sumM(BigInteger p, BigInteger q) {
        p = p.subtract(BigInteger.ONE);
        q = q.subtract(BigInteger.ONE);
        m = p.multiply(q);
        return m;
    }

    public BigInteger sumE() {
        for (e = BigInteger.valueOf(2); e.compareTo(m) < 0; e = e.add(BigInteger.ONE)) {
            if (m.gcd(e).equals(BigInteger.ONE)) {
                return e;
            }
        }
        return e;
    }

    public BigInteger sumD() {
        BigInteger k;
        BigInteger de;
        for (k = BigInteger.valueOf(0); k.compareTo(BigInteger.ZERO) >= 0; k = k.add(BigInteger.ONE)) {
            de = m.multiply(k);
            de = de.add(BigInteger.ONE);
            if (de.mod(e).equals(BigInteger.ZERO)) {
                d = (m.multiply(k).add(BigInteger.ONE)).divide(e);
                return d;
            }
        }
        return d;
    }
//Hello world! discrete Math is important subject. 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Two distinct upper limits for the two primes p,q:");
        System.out.print("upper limit for p:");
        long ulp = sc.nextInt();
        System.out.print("upper limit for q:");
        long ulq = sc.nextInt();
        BigInteger i;
        BigInteger p = BigInteger.valueOf(0);
        BigInteger q = BigInteger.valueOf(0);
        for (i = BigInteger.valueOf(ulp);
                i.compareTo(BigInteger.TWO) >= 0;
                i = i.subtract(BigInteger.ONE)) {
            boolean isltPrime = checkForPrime(i);
            if (isltPrime == true) {
                p = i;
                System.out.println("p = " + p);
                break;
            }
        }
        for (i = BigInteger.valueOf(ulq);
                i.compareTo(BigInteger.TWO) >= 0;
                i = i.subtract(BigInteger.ONE)) {
            boolean isltPrime = checkForPrime(i);
            if (isltPrime == true) {
                q = i;
                System.out.println("q = " + q);
                break;
            }
        }
        RSA_project tl = new RSA_project();
        System.out.println("n = " + tl.sumN(p, q));
        System.out.println("m = " + tl.sumM(p, q));
        System.out.println("e = " + tl.sumE());
        System.out.println("d = " + tl.sumD());
        System.out.print("Enter Original Message:");
        sc.nextLine();
        String plain = sc.nextLine();
        String in = "", out = "";
        for (int j = 0; j < plain.length(); j++) {
            BigInteger x = new BigInteger(String.valueOf((int) (plain.charAt(j))));
            BigInteger y = x.modPow(tl.e, tl.n);
            BigInteger z = y.modPow(tl.d, tl.n);
            out += (char) y.intValue();
            in += (char) z.intValue();
        }
//System.out.println("Enter Original Message:"+plain);
        System.out.println("Cipher Message : " + out);
        System.out.println("Decrypted Mssage : " + in);

    }
}
