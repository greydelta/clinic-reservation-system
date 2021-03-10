<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url] [![Stargazers][stars-shield]][stars-url] [![Issues][issues-shield]][issues-url]

<br />
<div align="center">

<h3 align="center">Clinic Reservation System</h3>

  <p align="center">
    A reservation system to manage booking appointments
    <br />
    <a href="https://github.com/greydelta/clinic-reservation-system"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/greydelta/clinic-reservation-system">View Demo</a>
    ·
    <a href="https://github.com/greydelta/clinic-reservation-system/issues">Report Bug</a>
    ·
    <a href="https://github.com/greydelta/clinic-reservation-system/issues">Request Feature</a>
  </p>
</div>

<!-- ABOUT THE PROJECT -->

## About The Project

Program behaviour:

1. Key Features of the system:

- Only Staff and Doctor will be able to use the system
- Staff will help patient:
  > - Create patient profile
  > - Create / update booking

2. Staff has more access control than the doctor since doctor just needs to view patient record and information

3. There are 3 different status for an appointment: ("Booked"/"Cancelled"/"Consulted")

4. A patient can only have 1 active appointment ("Booked") at any one time

   > - if patient has at least 1 booking with status = "Booked"
   > - then they are restricted from creating a new booking
   > - unless the booking is updated to "Cancelled" or "Booked"
   > - **Note:** Staff can update "Cancelled" to "Booked"/"Consulted"

5. During creation of New Patient Profile, the program will check if it matches an existing profile where:

   > `if name && contact != same`
   >
   > > Proceed to Create New Profile

   > `else if name && contact == same`
   >
   > > Prompt Profile Exist!

   > **Note:** Implies that 2 patients can have the same name but not the same number

6. Update Patient Profile feature only for **name/contact**
7. Update Appointment feature only for **status/date/time** (not allowed to change doctor)
8. Update Appointment Logic:

- **Scenario 1: Patient HAS existing booking**

  > `if(selectedBooking == "Booked")`
  >
  > > ❌ Not Allowed to: Update "Booked" to "Booked"

  > > ✔ Allowed to: Update "Booked" to "Cancelled"/"Consulted"

  > `else if(selectedBooking != "Booked")`
  >
  > > ❌ Not Allowed to: Update "Cancelled"/"Consulted" to "Booked"

  > > ✔ Allowed to: Update "Cancelled"/"Consulted" to "Cancelled"/"Consulted"

- **Scenario 2: Patient has NO existing booking**
  > > ✔ Allowed to: Update "Cancelled"/"Consulted" to "Booked" ✔ Allowed to: Update "Cancelled"/"Consulted" to "Cancelled"/"Consulted"

7. Since this is a runtime only application, logging in as doctor, will only display those appointments that are in the `appointment.txt` file. However, any appointment added during runtime will also be included in the core functionalities of all the functions and would be expected to behave accordingly.

8. Almost all functions require the input of Patient's Name and Contact number before proceeding to perform the selected function.

9. All login credentials/existing patients/existing bookings can be viewed in their respective `.txt` files.

<p align="right">(<a href="#top">back to top</a>)</p>

### Sample Output

[![program sample output 1][product-video]](#)

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/en/)

<p align="right">(<a href="#top">back to top</a>)</p>

## Getting Started

## Using [![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://www.eclipse.org/ide/) :

#### Prerequisites

- Install [Extension Pack for Java](vscode:extension/vscjava.vscode-java-pack)

#### Installation

- Import Project Folder in VS Code

#### Usage

1. Right click on `App.java`

1. Click "Run Java"

<p align="right">(<a href="#top">back to top</a>)</p>

## Using [![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://www.eclipse.org/ide/) :

#### Prerequisites

- Download & install [JRE-15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) and above according to your OS

#### Installation

1. Import Project Folder in Eclipse IDE

1. Right click on Project Folder in Project Folder View

1. Click "Build Path"

1. Click "Configure Build Path"

1. Under the "Libraries" Tab, click JRE System Library

1. Click "Edit"

1. Under "Execution Environment", choose "JavaSE-15 (jre)" from the dropdown

1. Click "Finish" then "Apply and Close"

### Usage

1. Right click on Project Folder in Project Folder View

1. Click "Run As"

1. Click "Java Application"

<p align="right">(<a href="#top">back to top</a>)</p>

## Contact

Your Name - [@greydelta1](https://twitter.com/greydelta1)

Project Link: [https://github.com/greydelta/clinic-reservation-system](https://github.com/greydelta/clinic-reservation-system)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

- []()
- []()
- []()

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/greydelta/clinic-reservation-system.svg?style=for-the-badge
[contributors-url]: https://github.com/greydelta/clinic-reservation-system/graphs/contributors
[stars-shield]: https://img.shields.io/github/stars/greydelta/clinic-reservation-system.svg?style=for-the-badge
[stars-url]: https://github.com/greydelta/clinic-reservation-system/stargazers
[issues-shield]: https://img.shields.io/github/issues/greydelta/clinic-reservation-system.svg?style=for-the-badge
[issues-url]: https://github.com/greydelta/clinic-reservation-system/issues
[product-screenshot]: images/visual.png
[product-video]: resources/video.gif
