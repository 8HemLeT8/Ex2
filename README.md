***
# Second project of Snir && Barel
***
##### The porpuse of this project:
read a csv file, translate its' information to our methods of *GIS* and then convert the information to a kml type of file to be able to show the information in the program of *Google Earth*.
***
##### *This project contains the following Packages*:
* **GIS** - Objects to save the information of the  csv file **|** While *Element* represents a single dot (a single line in the *CSV* file, *Layer* represents 1 full *CSV* file, and *Project* represents a combination of few *CSV* files.
* **Algorithms** - Converting a **number** of *CSV* files to **1** *KML* file
* **Coords** - Includes a cordinate tranformations and actions on points & vectors
* **File_format** - Contains the classes that are responsible to the tranforamtion of the *CSV* file to the *KML* file
* **Geom** -  Contains the object *Point3D* which represents the geographic inforamtion of a certain *Element*
***
## How to use it?

##### In the case of converting a single CSV file:
Open the class *Main* in the *File_format* package , insert the file path in the String *ReadMeFile* and run the program. You will get the message *done* in the console that tells that the *KML* file was successfuly created.
    
	//If the file is in the project dictionary just insert here its' name:
	String ReadMeFile = "WigleWifi_20171201110209.csv";

##### In the case of converting a dictionary full of CSV files to a single KML file:
Open the class *MultiCSV* in the Algorithms package, in the *main* method enter the path to the dictionary in the String *maindirpath* and hit the run button, same as before after the message *done* in the console your KML file is ready.

	// Provide full path for directory(change accordingly) 
	String maindirpath = "C:\\Users\\*YOUR_NAME*\\Desktop\\MashuMashu"; 
			
***
#### Enjoy && Have a great day! ☺
