# Coffee-Cart Rewards Test Cases - Team 24
## 1 Introduction
In order to thoroughly test the Coffee-Cart Rewards app we will conduct a combination of automated functional tests and manual usability tests.  All usability tests assume that the underlying requirements are satisfied, they are just being used to determine if the app is user-friendly.  The automated functional tests will be broken down into unit tests for individual components, integration tests for checking the transitions between major modules, and system tests for testing entire use cases. Note although the intent is to automate all of the functional tests, if there is not enough time some will be performed manually.
## 2 Test Cases
| Test Case ID	| Test Case Name	| Test Type	| Functional Type | Related User Story |
|---			|---		|---		|---			|--- |
| 1	| [Register VIP Customer](#user-content-2-1-register-vip-customer)	| Functional | Unit | 1 |
| 2	| [Delete VIP Customer](#user-content-2-2-delete-vip-customer)	| Functional | Unit | 2 |
| 3	| [Edit VIP Customer](#user-content-2-3-edit-vip-customer)	| Functional | Unit | 3 |
| 4	| [Pre-order Dessert](#user-content-2-4-pre-order-dessert)	| Functional | System | 4 |
| 5	| [Manage Dessert Best-Sellers](#user-content-2-5-manage-dessert-best-sellers)	| Functional | Unit | 5 |
| 6	| [Generate Dessert Pre-order Report](#user-content-2-6-generate-dessert-pre-order-report)	| Functional | Unit | 6 |
| 7	| [Purchase Items](#user-content-2-7-purchase-items) | Functional | System | 7 |
| 8	| [Calculate Discounts](#user-content-2-8-calculate-discounts)	| Functional | Unit | 8 |
| 9	| [Determine VIP Level](#user-content-2-9-determine-vip-level)	| Functional | Unit | 9 |
| 10 | [Calculate Purchase History](#user-content-2-10-calculate-purchase-history)	| Functional | Unit | 10 |
| 11 | [Generate Purchase Report](#user-content-2-11-generate-purchase-report)	| Functional | Integration | 11 |
| 12 | [Create New Item](#user-content-2-12-create-new-item)	| Functional | Unit | 12 |
| 13 | [Delete Item](#user-content-2-13-delete-item)	| Functional | Unit | 13 |
| 14 | [Edit Item](#user-content-2-14-edit-item)	| Functional | Unit | 14 |
| 15 | [Register Duplicate VIP Customer](#user-content-2-15-register-vip-customer)	| Functional | Unit | 1 |
| 16 | [VIP Number Uneditable](#user-content-2-16-vip-number-uneditable)	| Functional | Unit | 2 |
| 17 | [Pre-order Full Slots](#user-content-2-17-pre-order-full-slots)	| Functional | Unit | 4 |
| 18 | [Pre-order Best-seller Full Slots](#user-content-2-18-pre-order-best-seller-full-slots)	| Functional | Unit | 4 |
| 19 | [Deleted Item Pre-order](#user-content-2-19-deleted-item-pre-order)	| Functional | System | 4, 13 |
| 20 | [Deleted Item Pre-order Report](#user-content-2-20-deleted-item-pre-order-report)	| Functional | System | 6, 13 |
| 21 | [Deleted Item Purchase](#user-content-2-21-deleted-item-purchase)	| Functional | System | 7, 13 |
| 22 | [Deleted Item Purchase Report](#user-content-2-22-deleted-item-purchase-report)	| Functional | System | 11, 13 |
| 23 | [Deleted Item Purchase History](#user-content-2-23-deleted-item-purchase-history)	| Functional | Integration | 11, 10 |
| 24 | [Easy To Purchase](#user-content-2-24-easy-to-purchase)	| Usability | Not Applicable | 7 |
| 25 | [Easy To Pre-order](#user-content-2-25-easy-to-pre-order)	| Usability | Not Applicable | 4 |
| 26 | [Easy To Manage Customers](#user-content-2-26-easy-to-manage-customers)	| Usability | Not Applicable | 1, 2, 3 |
| 27 | [Easy To Manage Items](#user-content-2-27-easy-to-manage-items)	| Usability | Not Applicable | 12, 13, 14 |
| 28 | [Easy To Generate Reports](#user-content-2-28-easy-to-generate-reports)	| Usability | Not Applicable | 11, 20 |
| 29 | [Data Persisted](#user-content-2-29-data-persisted) | Functional | Unit | All |
| 30 | [Database Created](#user-content-2-30-database-created) | Functional | Unit | All |
| 31 | [Database Upgraded](#user-content-2-31-database-upgraded) | Functional | Unit | All |
| 32 | [App Suspends Properly](#user-content-2-32-app-suspends-properly) | Functional | Unit | All |
### 2.1 Register VIP Customer
1. Objective: The objective of this test is to verify that the user can register a new VIP customer.
2. Steps:
  1. From the main screen click on Customers
  2. From the Customers screen click on create new customer
  3. Fill in all details for the new customer
  4. Verify that you are redirected to the Customers screen
  5. Verify that the new VIP customer was created by browsing through the list of VIP customers
  6. Click on the new VIP customer
  7. Verify that the new VIP customer has the correct information and has a VIP rewards number
3. Pass Criteria:
  * All screens mentioned exist
  * The new VIP customer exists on the Customers screen
  * All VIP customer information is correct

### 2.2 Delete VIP Customer
1. Objective: The objective of this test is to verify that the user can delete a VIP customer.
2. Steps:
  1. From the main screen click on Customers
  2. From the Customers screen find the correct VIP customer
  3. Click on the customer, verify that you are on the show customer screen
  4. From the actionbar menu select delete
  5. Verify that you are redirected to the Customers screen and that the VIP customer no longer exits
3. Pass Criteria:
  * All screens mentioned exist
  * The VIP customer is no longer contained on the Customers screen

### 2.3 Edit VIP Customer
1. Objective: The objective of this test is to verify that the user can edit a VIP customer.
2. Steps:
  1. From the main screen click on Customers
  2. From the Customers screen find the correct VIP customer
  3. Click on the customer, verify that you are on the show customer screen
  4. From the actionbar menu select edit
  5. Verify that you are redirected to the edit customer screen
  6. Edit customer details
  7. Click update
  8. Verify that you are on the Customers screen
  9. Find the customer again and verify their details are updated
3. Pass Criteria:
  * All screens mentioned exist
  * The VIP customer successfully has its information updated

### 2.4 Pre-order Dessert
1. Objective: The objective of this test is to verify that the user pre-order a dessert for a given customer
2. Steps:
  1. From the main screen click on Pre-order
  2. Search and select the customer for whom the pre-order is for
  3. Search and select the dessert desired
  4. Select the correct date for the pre-order
  5. Confirm the pre-order
  6. Generate the pre-order report for the given day
  7. Verify that the new pre-order is on the report
3. Pass Criteria:
  * All screens mentioned exist
  * The new pre-order is on the generated report

### 2.5 Manage Dessert Best-Sellers
1. Objective: The objective of this test is to verify that the user can update whether a dessert is a best-seller
2. Steps:
  1. From the main screen click on Inventory
  2. Search and select the correct dessert
  3. Click on the dessert
  4. On the dessert details screen click edit from the action bar
  5. Change the best-seller option to true or false
  6. Verify that this is updated by selecting the item again
3. Pass Criteria:
  * All screens mentioned exist
  * The dessert best-seller flag is updated

### 2.6 Generate Dessert Pre-order Report
1. Objective: The objective of this test is to verify that the user can generate a dessert pre-order report
2. Steps:
  1. From the main screen click on Reports
  2. Enter the date for the report (make sure this date has data)
  3. Click generate report
  4. Confirm that the report has all pre-orders entered for that day
3. Pass Criteria:
  * The report is generated
  * The report data is correct

### 2.7 Purchase Items
1. Objective: The objective of this test is to verify that the user can complete a purchase
  2. Steps:
    1. From the main screen click on Purchase
    2. Search and select the customer for whom the purchase is for
    3. Search and select the items desired
    4. Verify the total
    5. Verify the discounts
    6. Complete the purchase
    7. Generate the purchase report and confirm that the new purchase is there for the given day
  
3. Pass Criteria:
    * The purchase can be completed successfully 
    * The new purchase shows on the purchase report for the given day

### 2.8 Calculate Discounts
1. Objective: The objective of this test is to verify that the VIP customer gets the correct discounts
2. Steps:
  1. From the main screen click on Purchase
  2. Search and select the customer for whom the purchase is for
  3. Search and select a coffee refill
  4. Verify the total
  5. Verify the discounts (which should be half off for VIP customers and free for GOLD VIP customers)
3. Pass Criteria:
  * Coffee refills are half off for VIP customers
  * Coffee refills are free for GOLD VIP customers

### 2.9 Determine VIP Level
1. Objective: The objective of this test is to verify that the VIP level calculated is correct
2. Steps:
  1. From the main screen click on Purchase
  2. Search and select the customer for whom the purchase is for (make sure the customer is a GOLD VIP customer)
  3. Search and select a coffee refill
  4. Verify the total
  5. Verify the discounts (which should be free for GOLD VIP customers)
3. Pass Criteria:
  * The selected VIP customer really does have GOLD level
  * Coffee refills are free for GOLD VIP customers


### 2.10 Calculate Purchase History
1. Objective: The objective of this test is to verify the purchase history is correct for a given customer (can only be done as a backend test)
2. Steps:
  1. Generate a bunch of purchases for a VIP customer, recording each one
  2. Make a call to generate the purchase history
  3. Verify all purchases are in the purchase history
  4. Verify the points total is correct
3. Pass Criteria:
  * All purchases setup are returned
  * Points total is correct

### 2.11 Generate Purchase Report
1. Objective: The objective of this test is to verify the purchase report for a given day
2. Steps:
  1. Generate a bunch of purchases for many VIP customers, taking note of each one
  2. From the main screen select Reports
  3. Select Purchases
  4. Enter the date required for the report
  5. Click generate
  6. Verify all purchases created are on the report broken out by customer
3. Pass Criteria:
  * All purchases setup are on the report
  * Purchases are broken down by customer
  * Multiple purchases are allowed per customer on the report

### 2.12 Create New Item
1. Objective: The objective of this test is to create a new item
2. Steps:
  1. From the main screen select Inventory
  2. Click Create New Item
  3. Enter the details of the new item
  4. Click update
  5. Browse through all items confirming the new item exists
  6. Click on the new item and verify its details
3. Pass Criteria:
  * The user is able to create a new item
  * The item shows up on the Inventory screen
  * The items details are correct

### 2.13 Delete Item
1. Objective: To verify that an item can be deleted
2. Steps:
  1. From the main screen select Inventory
  2. Find the correct item
  3. Click on the item
  4. From the actions menu select delete
  5. Verify that you are redirected to the Inventory screen
  6. Verify the item is no longer there
3. Pass Criteria:
  * The item is successfully deleted

### 2.14 Edit Item
1. Objective: To verify that a user can edit the details of an item
2. Steps:
  1. From the main screen select Inventory
  2. Find the correct item
  3. Click on the item
  4. From the actions menu select edit
  5. Update any field
  6. Click update
  7. Find the item from the Inventory screen
  8. Click on it
  9. Verify its information is updated
3. Pass Criteria:
  * The item is successfully updated

### 2.15 Register Duplicate VIP Customer
1. Objective: The objective of this test is to verify that the user cannot register a duplicate VIP customer.
2. Steps:
  1. From the main screen click on Customers
  2. From the Customers screen click on create new customer
  3. Fill in all details for the new customer
  4. Verify that you are redirected to the Customers screen
  5. Verify that the new VIP customer was created by browsing through the list of VIP customers
  6. Click on the new VIP customer
  7. Verify that the new VIP customer has the correct information and has a VIP rewards number
  8. Repeat steps 1-3, click update
  9. Verify that the app rejects the update informing the user that the VIP customer already exists
3. Pass Criteria:
  * The app rejects duplicate contact creation
  * The app informs the user of the duplicate VIP customer

### 2.16 VIP Number Uneditable
1. Objective: The objective of this test is to verify that the user cannot edit a VIP customer's VIP number.
2. Steps:
  1. From the main screen click on Customers
  2. From the Customers screen find the correct VIP customer
  3. Click on the customer, verify that you are on the show customer screen
  4. Verify that the VIP number is shown
  5. From the actionbar menu select edit
  6. Verify that you are redirected to the edit customer screen
  7. Confirm that the VIP number is not shown to be edited
3. Pass Criteria:
  * The VIP number is shown on the show customer screen
  * The VIP number is not shown or editable on the edit customer screen

### 2.17 Pre-order Full Slots
1. Objective: The objective of this test is to verify that the user cannot exceed the number of pre-order slots for a given dessert on a given day
2. Steps:
  1. From the main screen click on Pre-order
  2. Search and select the customer for whom the pre-order is for
  3. Search and select the dessert desired
  4. Select the correct date for the pre-order
  5. Confirm the pre-order
  6. Repeat steps 1-5 with the same dessert and date (4 more times) 
  7. Attempt steps 1-5 one more time, verifying that the pre-order is rejeted
  8. Confirm the user is informed that the number of slots are full
3. Pass Criteria:
  * The user is rejected when attempting to pre-order a dessert that is full

### 2.18 Pre-order Best-seller Full Slots
1. Objective: Confirm that the user is not able to create more than 3 pre-orders for a given best-seller dessert and day
2. Steps:
  1. Follow steps 1-6 of 2.17, except only repeat twice and make sure the dessert is a best-seller
  2. Confirm when trying to place new pre-order for the dessert on the given day that the user is rejected
3. Pass Criteria:
  * The user is rejected when attempting to pre-order a dessert that is full

### 2.19 Deleted Item Pre-order
1. Objective: Confirm that a user cannot place any pre-order for a deleted dessert after their delete date, and that the existing pre-orders for before that date are not removed
2. Steps:
  1. Go delete that dessert from the Inventory screen
  2. Attempt to setup a pre-order for after the deletion date
  3. Confirm that this is not allowed and the user is informed of why
3. Pass Criteria:
  * The user is not allowed to setup a new preorder for after the deletion date
  * The user is informed of why

### 2.20 Deleted Item Pre-order Report
1. Objective: Confirm that the pre-order reports for before a dessert was deleted still show the dessert and the reports for after the deletion date do not show the dessert
2. Steps:
  1. Create pre-orders for a dessert for before and after a given date
  2. Go delete that dessert from the Inventory screen
  3. Generate a dessert pre-order report for the date before the deletion and one for after the deletion
  4. Verify that the report for before the deletion date still contains that dessert
  5. Verify that the report for after the deletion date does not contain that dessert
3. Pass Criteria:
  * The generated reports are correct

### 2.21 Deleted Item Purchase
1. Objective: Confirm that a deleted item cannot be purchased
2. Steps:
  1. Delete an item
  2. Create a new purchase
  3. Verify that the deleted item cannot be added to the purchase
3. Pass Criteria:
  * A deleted item cannot be added to a new purchase

### 2.22 Deleted Item Purchase Report
1. Objective: Confirm that a deleted item still shows on a purchase report
2. Steps:
  1. Create many purchases with an item
  2. Delete that item
  3. Generate purchase reports for the days of the purchases in step 1
  4. Verify that the deleted item is still on the generated reports
3. Pass Criteria:
  * A deleted item should still show on purchase reports

### 2.23 Deleted Item Purchase History
1. Objective: Confirm that a deleted item still shows on a VIP customers purchase history (must be backend)
2. Steps:
  1. Create many purchases with an item for a given customer, recording the total number
  2. Delete that item
  3. Generate the purchase history for the given customer
  4. Confirm that the purchase history has the deleted item the number of times it was purchsed in step 1
3. Pass Criteria:
  * A deleted item should still show on VIP customers purchase history

### 2.24 Easy To Purchase
1. Objective: Ensure that it is easy for a coffee-cart manager to complete a purchase
2. Steps:
  1. Show a new user the user manual
  2. Tell them to create a new purchase
  3. Observe them create a new purchase
  4. Ask the user if there are any pain points
  5. Take note of any area where the user took longer than expected
  6. If needed address pain points from 4 and 5
3. Pass Criteria:
  * No pain points are mentioned by user
  * No user delay is noticed in observation

### 2.25 Easy To Pre-order
1. Objective: Ensure that it is easy for a coffee-cart manager to complete a pre-order
2. Steps:
  1. Show a new user the user manual
  2. Tell them to create a new pre-order
  3. Observe them create a new pre-order
  4. Ask the user if there are any pain points
  5. Take note of any area where the user took longer than expected
  6. If needed address pain points from 4 and 5
3. Pass Criteria:
  * No pain points are mentioned by user
  * No user delay is noticed in observation

### 2.26 Easy To Manage Customers
1. Objective: Ensure that it is easy for a coffee-cart manager to manage VIP customers
2. Steps:
  1. Show a new user the user manual
  2. Tell them to create a new VIP customer, edit an existing VIP customer, and delete and existing VIP customer
  3. Observe them do so
  4. Ask the user if there are any pain points
  5. Take note of any area where the user took longer than expected
  6. If needed address pain points from 4 and 5
3. Pass Criteria:
  * No pain points are mentioned by user
  * No user delay is noticed in observation

### 2.27 Easy To Manage Items
1. Objective: Ensure that it is easy for a coffee-cart manager to manage items
2. Steps:
  1. Show a new user the user manual
  2. Tell them to create a new item, edit an existing item, and delete and existing item
  3. Observe them do so
  4. Ask the user if there are any pain points
  5. Take note of any area where the user took longer than expected
  6. If needed address pain points from 4 and 5
3. Pass Criteria:
  * No pain points are mentioned by user
  * No user delay is noticed in observation

### 2.28 Easy To Generate Reports
1. Objective: Ensure that it is easy for a coffee-cart manager to generate reports
2. Steps:
  1. Show a new user the user manual
  2. Tell them to generate a purchase report and a pre-order report
  3. Observe them do so
  4. Ask the user if there are any pain points
  5. Take note of any area where the user took longer than expected
  6. If needed address pain points from 4 and 5
3. Pass Criteria:
  * No pain points are mentioned by user
  * No user delay is noticed in observation

### 2.29 Data Persisted
1. Objective: Ensure that data is actually persisted between runs
2. Steps:
  1. Start app
  2. Create a new item, customer, purchase, and pre-order
  3. Stop app and start again
  4. Verify that everything created still exists
3. Pass Criteria:
  * Data is persisted between runs

### 2.30 Database Created
1. Objective: Ensure that database is actually created
2. Steps:
  1. Start app
  2. Create a new item, customer, purchase, and pre-order
  3. Stop app
  4. Find the database file on the android filesystem
  5. Confirm database name with development
3. Pass Criteria:
  * Database is actually created
  * Database name is correct

### 2.31 Database Upgraded
1. Objective: Ensure that the database is upgraded properly
2. Steps:
  1. Modify the database version
  2. Start the app
  3. Verify that data is migrated properly
3. Pass Criteria:
  * Database is upgraded
  * Existing data is not lost

### 2.32 App Suspends Properly
1. Objective: Ensure the app suspends properly
2. Steps:
  1. Start app
  2. Navigate to another app or the home screen
  3. Resume app
  4. Confirm that the screen you were on is the one that is started on resume
  5. Confirm that database functionality is still working (create, edit, or delete something)
3. Pass Criteria:
  * App suspends
  * App resumes on the correct screen
  * Database functionality still works
