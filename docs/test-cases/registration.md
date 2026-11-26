# Registration page test cases  
___
[<<< Back to README](../../README.md)

___

## TC-REG-001

- **Title:**  Verify that the Name field displays an error style when submitted empty
- **Priority:** Medium
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Last Name: "Tester", Email: "example@test.com", Phone number: "0661111111"

| Steps | Actions                                                           | Expected result                                |
|-------|-------------------------------------------------------------------|------------------------------------------------|
| 1     | Open the Registration Page                                        | The Registration Page is open                  |
| 2     | Fill in all required fields except the Name field with valid data | The Name field does not display an error style |
| 3     | Click the Submit button                                           | The Name field displays an error style         |

- **Automated:** [NameFieldTest.java](../../src/test/java/tests/registration/NameFieldTest.java)

---

## TC-REG-002

- **Title:** Verify that the Password generator changes the password on each click
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** N/A

| Steps | Actions                            | Expected result                                            |
|-------|------------------------------------|------------------------------------------------------------|
| 1     | Open the Registration Page         | The Registration Page is open                              |
| 2     | Click the Generate password button | The Password field is not empty and the password is hidden |
| 3     | Click the Show password button     | The password is visible                                    |
| 4     | Click the Generate password button | The password is changed                                    |

- **Automated:** [PasswordGeneratorTest.java](../../src/test/java/tests/registration/PasswordGeneratorTest.java)

---

## TC-REG-003

- **Title:** Verify that the password strength indicator changes according to the password complexity
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Weak Password: "<91", Medium Password: "<91S/jQ", Strong Password: "<91S/jQ4$acG"

| Steps | Actions                                     | Expected result                                       |
|-------|---------------------------------------------|-------------------------------------------------------|
| 1     | Open the Registration Page                  | The Registration Page is open                         |
| 2     | Enter Weak Password in the Password field   | The Password strength indicator is visible and red    |
| 3     | Enter Medium Password in the Password field | The Password strength indicator is visible and orange |
| 4     | Enter Strong Password in the Password field | The Password strength indicator is visible and green  |

- **Automated:** [PasswordStrengthIndicatorTest.java](../../src/test/java/tests/registration/PasswordStrengthIndicatorTest.java)

---

## TC-REG-004

- **Title:** Verify that the Registration agreement checkbox can be checked
- **Priority:** Medium
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** N/A

| Steps | Actions                                   | Expected result                                                                    |
|-------|-------------------------------------------|------------------------------------------------------------------------------------|
| 1     | Open the Registration Page                | The Registration Page is open and the Registration agreement checkbox is unchecked |
| 2     | Click the Registration agreement checkbox | The Registration agreement checkbox is checked                                     |

- **Automated:** [RegistrationAgreementCheckboxTest.java](../../src/test/java/tests/registration/RegistrationAgreementCheckboxTest.java)

---

## TC-REG-005

- **Title:** Verify that the Show password button changes the Password field type
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** N/A

| Steps | Actions                        | Expected result                                                          |
|-------|--------------------------------|--------------------------------------------------------------------------|
| 1     | Open the Registration Page     | The Registration Page is open and the Password field has type "password" |
| 2     | Click the Show password button | The Password field has type "text"                                       |

- **Automated:** [ShowPasswordButtonTest.java](../../src/test/java/tests/registration/ShowPasswordButtonTest.java)