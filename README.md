# Analyze Customer Reviews Using Big Data AWS Hadoop EC2 Instance
## Overview
This is a Java based mapper, reducer and driver program written in Java which uses AWS's Hadoop instance to achieve the folowing goal:
- Total number of reviews per product
- Average rating per product

There are 4 CSV files used as an input which contains customers' data as follows:
- Gift_Cards.csv
- Automotive.csv
- CDs_and_Vinyls.csv
- Cell_Phones_and_Accessories.csv

The file format is CSV, which uses comma to separate the fields in each row. Each line of the file represents one data record. We are primarily be interested in the id of a product (the 1st column) and the rating of product (the 3rd column). The sample file (Gift_Cards.csv) is provided for you to see some sample data and structure of the file.

The MapReduce application will compute the total number of reviews and the average rate of each product. Note that each review record has a rating in it (i.e. the number of ratings = the number of reviews). The output should contain three columns (product_id, total number of reviews of this product, the average rate of this product).
The program is exeuted against the dataset review_data.zip (which contains the rest 3 csv files).

## Output:
The 1st 10 lines of output:

<img width="632" height="427" alt="image" src="https://github.com/user-attachments/assets/39084be6-427f-4abf-8d58-a640af4dcd73" />

## How To Run:
1. Open AWS console and select the region (mine is us-west-2 i.e Oregon). This is the 1st thing that you should do everytime you log on.
2. Find “Key Pairs” on the left nav bar. Select “Create Key Pair” at the upper right. This is created only once. Give the key pair a name (must be a valid Linux file name, so use just letters numbers, dashes and underscores). I used bda_demo for this project. Select RSA as the key pair type, and .pem (for use with OpenSSH). When you click “Create” you will notice that a file bda_demo.pem was automatically downloaded to your laptop. A key pair is a pair of files that allow you to connect to an EC2 instance without a password. One file (the public key file) is stored on the client, your laptop. The other file (the private key file) is stored on the server, the AWS cloud.
3. Goto EC2 instance from the menu and name your instance bda_demo (or any of your choice) and attach the key to the instance.
4. I switch to my laptop terminal app – for me it’s Windows Terminal running Ubuntu. Ubuntu can be installed using WSL (Windows Subsytem for Linux).
5. Start Hadoop on the EC2 instance and put all your input java files with the datasets.
6. Create jar files and run the driver then mapper and reducer files to see the output in the terminal.
