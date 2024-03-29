/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dz__10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author petr-
 */
public class DZ__10 {

    public static void main(String[] args) {
        System.out.println("Practical task 1.10, Student Dmitry Poluektov, RIBO-01-22, Variant 3");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к входному файлу: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Введите байты гаммы: ");
        byte gammaByte = (byte) scanner.nextInt();

        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            byte[] inputBytes = new byte[inputStream.available()];
            inputStream.read(inputBytes);
            inputStream.close();

            byte[] outputBytes = new byte[inputBytes.length];
            for (int i = 0; i < inputBytes.length; i++) {
                outputBytes[i] = (byte) (inputBytes[i] ^ gammaByte);
            }

            String outputFilePath = inputFilePath.replace(".txt", "_modified.txt");
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            outputStream.write(outputBytes);
            outputStream.close();

            System.out.println("Файл успешно модифицирован. Результат сохранен в " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка обработки файла: " + e.getMessage());
        }
    }
}
