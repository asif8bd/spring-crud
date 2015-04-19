function validateInputForm() {
    var studentName = document.forms["myForm"]["studentName"].value;
    var studentEmail = document.forms["myForm"]["studentEmail"].value;
    if (studentName == null || studentName == "") {
    	document.getElementById('studentName').focus();
        return false;
    }else if (studentEmail == null || studentEmail == "") {
    	document.getElementById('studentEmail').focus();
        return false;
    }
}