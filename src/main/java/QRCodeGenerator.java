/*
***********************************************************************
* Program Name: QR Code Generator                                     *
* Author: Dervin Altenor                                              *
* Date Created: Thu Apr 25, 2024, 2:26 AM                             *
***********************************************************************

Description:
------------
This program allows users to generate QR code images from their input data.
The generated QR code images are saved to the specified directory path.

How to Use:
-----------
1. Choose the directory path where you want to save the QR code image.
2. Run the program.
3. Enter the data you want to encode into a QR code when prompted.
4. Specify the desired file format for the QR code image (e.g., PNG, JPEG).

Note:
-----------
*Example of directory path for Mac users: /Users/YourUsername/Downloads/
*Example of directory path for Windows users: C:\Users\YourUsername\Downloads\
"Downloads" can be replaced with path of your choosing.*

 */




import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;

import java.util.Scanner;

public class QRCodeGenerator {
    public static void main(String[] args) {

        System.out.println("Hello! This is a program to turn user input into a QR code image.");
        System.out.print("Provide the content you wish to convert into a QR code: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        System.out.print("What should we call your QR code image? ");
        Scanner qrImageName = new Scanner(System.in);
        String userImageName = qrImageName.nextLine();

        System.out.print("Specify your desired file format: ");
        Scanner fileFormat = new Scanner(System.in);
        String fileFormatName = fileFormat.nextLine();

        getQRCode(userInput, userImageName, fileFormatName);
    }

    public static void getQRCode(String userInput, String userImageName, String fileFormatName){


        String path = "/Users/dervinaltenor/Downloads/" + userImageName +"." + fileFormatName;  //<------*Enter path directory here.* Specifies path for QR code to be downloaded
        int width = 500; //width for image
        int height = 200; //height for image

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(userInput, BarcodeFormat.QR_CODE, width, height);  //generates qrCode matrix with specified dimensions
            MatrixToImageWriter.writeToPath(matrix, fileFormatName.toUpperCase(), Paths.get(path));  //writes matrix to image file with inputted name and format
            System.out.println("QR code generated successfully.");
        } catch (WriterException | IOException e) {
            System.out.println("Error generating QR code: " + e.getMessage());
        }
    }
}
