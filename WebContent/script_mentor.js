function validate()
{ 
	 var fullname = document.form.fullname.value;
	 var email = document.form.email.value;
	 var username = document.form.username.value; 
	 var password = document.form.password.value;
	 var conpassword= document.form.conpassword.value;
	 
	 if (fullname==null || fullname=="")
	 { 
	 alert("Full Name can't be blank"); 
	 return false; 
	 }
	  else if (!hasNumber.test(password)) {
        alert("Password must contain at least one numerical character.");
    } else if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
    } else if (!hasAlphabet.test(password)) {
        alert("Password must contain at least one Alphabet character.");
    } else if (!hasSpecialChar.test(password)) {
        alert("Password must contain at least one special character.");
    }
    else if (confirm_password != password){
      alert("Confirm password should match with password.")
    }
    else if(mentor_mobile.length !=10){
      alert("Mobile Number should have 10 digits.")
    }
 } 