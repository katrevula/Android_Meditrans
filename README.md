# App Name:Meditrans
# App Logo: 
## Teammates:

1. Sravani Jaidi
1. Kavya Reddy Mylapurapu
1. Sandeep Katrevula
1. Rohan Goud Bandari
### Introduction to our project:
It is an application which is useful for Drug distributors to update/add available drugs for customers. Customer can view/search for the availability of drugs from different drugstores. 
This application helps customers to search for a drugstore along with availability of the desired drugs in stores up to date in Real. In addition, it also specifies if a store has delivery availability.

Our application can run in every Android mobile devices.
### Installation steps:

1. Clone our repo.
1. Open our project in Android studio.
1. Run the application in any AVD or GVD.
1. Install Google play services SDK in Android studio.

### Test Credentials:
UserID: Firstmedico@medico.com

Password: FirstMedico
### Apk file: 
Attached file is at Meditrans/app-debug.apk
### Supported Devices:
Any device with minimum Android Sdk version API21(5.0) our application works on that device.

Requires Google Play Services for Accessing Current location through Android Studio.

### Sequence Information:
1. A registered drug store can log into the application. If it is a new drug store, it has to register by providing necessary fields (examples: Shop Name, User Id, Address, Mobile Number, Open and Closing times, Location, Delivery Availability, … ) .Drug Store can add new drugs , update the availability of existing drugs and  also view the list of the drugs that are fetched from the database we will use(firebase). 
1. A registered drug store can also view the request that are requested by the customer. 
1.Customer can search for stores and they will be able to see the available drugs in that particular drug stores. They could request for a drug by adding prescription and other details (Ex: Name, Mobile Number, upload Prescription, …). 
1. If a customer searches for a particular drug, it will list out all the drug stores in which a requested drug available.
1. Drug store will be able to see the requests from customers. After reviewing the prescriptions, drugs will be delivered(if delivery is available for particular store)  after confirming it on a call by pressing a “call” button which redirects to placing a call (using drug store contact used while registration) to that particular customer .
1. There is an about us button where we can view details about the meditrans application, There is a Home button where we can go back to login page(Home page) irrespective of what page we are in.There is a contact us button where we can get in touch( with contact details) with the developers of the application .





