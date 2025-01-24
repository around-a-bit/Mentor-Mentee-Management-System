function validateInput() {
	alert("Script file loaded!");
  // Mobile number validation
  if (!validateMobile()) return false;

  // Email validation
  if (!validateEmail()) return false;

  // Password validation
  if (!validatePassword()) return false;

  // UID validation
  if (!validateUid()) return false;

  // All validations passed, allow form submission
  return true;
}

function validateMobile() {
  const hasNumber = /\d/;
  var mobile = document.form.mobile.value;

  if (mobile.length === 0) {
    alert("Mobile Number cannot be empty!");
    return false;
  }

  if (mobile.length !== 10) {
    alert("Mobile Number must be of 10 digits!");
    return false;
  }

  if (!hasNumber.test(mobile) || mobile.match(/\D/g)) {
    alert("Mobile Number must contain only digits!");
    return false;
  }

  if (/^0+$/.test(mobile)) {
    alert("Mobile Number cannot be all zeros!");
    return false;
  }

  if (/^(.)\1*$/.test(mobile)) {
    alert("Mobile Number cannot contain only one repeated digit!");
    return false;
  }

  if (mobile.startsWith('0')) {
    alert("Mobile Number cannot start with 0!");
    return false;
  }

  return true;
}

function validateEmail() {
  var email = document.form.email.value;
  if (email.length === 0) {
    alert("Email cannot be empty!");
    return false;
  }
  if (!email.includes('@')) {
    alert("Invalid Email!");
    return false;
  }
  if (!email.includes('.')) {
    alert("Invalid Email!");
    return false;
  }
  var atPosition = email.indexOf('@');
  if (atPosition < 1) {
    alert("Invalid Email!");
    return false;
  }
  var dotPosition = email.indexOf('.');
  if (dotPosition < atPosition + 2) {
    alert("Invalid Email!");
    return false;
  }
  var extension = email.substring(dotPosition + 1);
  if (extension.length < 2) {
    alert("Invalid Email!");
    return false;
  }
  return true;
}

function validatePassword() {
  var password = document.form.password.value;
  if (password.length === 0) {
    alert("Password cannot be empty!");
    return false;
  }
  if (password.length < 8) {
    alert("Password must be at least 8 characters long!");
    return false;
  }
  if (!/[a-z]/.test(password)) {
    alert("Password must contain at least one lowercase letter!");
    return false;
  }
  if (!/[A-Z]/.test(password)) {
    alert("Password must contain at least one uppercase letter!");
    return false;
  }
  if (!/[0-9]/.test(password)) {
    alert("Password must contain at least one digit!");
    return false;
  }
  if (!/[^a-zA-Z0-9]/.test(password)) {
    alert("Password must contain at least one special character!");
    return false;
  }
  if (/^(.)\1*$/.test(password)) {
    alert("Password cannot contain only one repeated character!");
    return false;
  }
  return true;
}

function validateUid() {
  var uid = document.form.uid.value;
  if (uid.length < 16 || uid.length > 17) {
    alert("UID must be between 16 and 17 characters!");
    return false;
  }
  return true;
}