# deals-project

Project Setup: I created a Maven project to manage dependencies and build the application Using spring boot and java version 11.
  - Clone the repo
  - create deals-project database using postgres ( you can update DB password in application.yaml)
  - run the project

Database Selection: I choosed PostgreSQL as the database to persist FX deals data due to its robustness and suitability for transactional operations.

Request Logic Implementation: I developed the logic to accept deals details, validate the row structure, and ensure that duplicate requests are not imported.

 1. Successfully creating the deal
![image](https://github.com/hadeel-ux/deals-project/assets/73706746/c175e7dc-ff59-4a7e-9992-3b33e3752eaf)

 2. Invalid Currency 
![image](https://github.com/hadeel-ux/deals-project/assets/73706746/30baa5f5-bbc9-4887-b527-c6a8010ee05d)

 3. Duplicated Deals
![image](https://github.com/hadeel-ux/deals-project/assets/73706746/8e34f0c0-6596-49f2-9a31-8531d2b8bdab)

 4. Empty Fields
![image](https://github.com/hadeel-ux/deals-project/assets/73706746/d8b8e3e2-3ff9-4516-b9c0-22bb2b096cb6)


Database Interaction: I implemeted database interaction to persist the imported data into the PostgreSQL database.

Error/Exception Handling: I implemeted proper error and exception handling mechanisms to ensure the reliability and stability of the application.

Unit Testing and Coverage: I will write comprehensive unit tests to cover all critical components of the application and ensure a high test coverage percentage.

Documentation: I implemeted the project using Markdown (md) format, including instructions for building, deploying, and running the application.

GitHub Repository: I implemeted a public GitHub repository to host the project code and documentation.


