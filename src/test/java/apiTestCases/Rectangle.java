package apiTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Serialization and Deserialization are programming techniques where we convert Objects to Byte Streams 
//and from Byte Streams back to Objects respectively
public class Rectangle implements Serializable {

	// Serialization is a process where you convert an Instance of a Class (Object
	// of a class) into a Byte Stream. This Byte Stream can then be stored as a file
	// on the disk or can also be sent to another computer via the network.
	// Serializable interface is a marker interface. Which means that you do
	// not have to implement any methods if your class derives from this interface.

	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	public double area() {

		return height * width;
	}

	public double perimeter() {

		return 2 * (height + width);
	}

	public static void serializeToFile(Object classObject, String filename) {

		try {
			// Step 1: Open a file output stream to create a file object on disk.
			// This file object will be used to write the serialized bytes of an object
			FileOutputStream fout = new FileOutputStream(filename);

			// Step 2: Create a ObjectOutputStream, this class takes a files stream.
			// This class is responsible for converting the Object of any type into
			// a byte stream

			ObjectOutputStream objos = new ObjectOutputStream(fout);

			// Step 3: ObjectOutputStream.writeObject method takes an Object and
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.

			objos.writeObject(classObject);

			// Step 4: Gracefully close the streams

			fout.close();
			objos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Rectangle rc = new Rectangle(25, 50);
		serializeToFile(rc, "rectSerialized");
		System.out.println("File got created at root directory!");

		// We will then read the object using ObjectInputStream and
		// store it in a variable of type Rectangle.

		Rectangle deserializedObject = (Rectangle) DeserializeFromFileToObject("rectSerialized");
		System.out.println("Rectangel area is : " + deserializedObject.area());
		System.out.println("Rectangel perimeter is : " + deserializedObject.perimeter());
	}

	public static Object DeserializeFromFileToObject(String fileName) {

		try {

			// Step 1: Create a file input stream to read the serialized content
			// of rectangle class from the file

			FileInputStream fis = new FileInputStream(new File(fileName));

			// Step 2: Create an object stream from the file stream. So that the content
			// of the file is converted to the Rectangle Object instance

			ObjectInputStream objis = new ObjectInputStream(fis);

			// Step 3: Read the content of the stream and convert it into object

			Object deserilizeClassObj = objis.readObject();

			// Step 4: Close all the resources

			fis.close();
			objis.close();

			return deserilizeClassObj;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return null;

	}

}
