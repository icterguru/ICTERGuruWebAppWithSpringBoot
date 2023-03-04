//document.cookie = "my_cookie_name=my_cookie_value; expires=Thu, 11 Jun 2070 11:11:11 UTC; path=/; SameSite=None; Secure";

const submitToSubscribe = document.querySelector('#submit-to-subscribe');

const saveStudentRecord = async () => {
//   let studentIdValue = document.getElementById('student-id').value
  let studentNameValue = document.getElementById('student-name').value
  let studentEemailValue = document.getElementById('student-email').value
  let studentPhoneValue = document.getElementById('student-phone').value
  let studentNotesValue = document.getElementById('student-notes').value

  let postResponse = await fetch('http://localhost:8088/savethestudent/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      // 'Content-Type': ['application/json', 'text/html', 'text/xml', 'text/css'],
    },
    body: JSON.stringify({
    //   studentId: studentIdValue,
      studentName: studentNameValue,
      studentEmail: studentEemailValue,
      studentPhone: studentPhoneValue,
      studentNotes: studentNotesValue
    })

  });
  const studentRecord = await postResponse.json();
  // Extracts JSON from the http response postResponse
  console.log(studentRecord);
  console.log(`The student record is saved successfully in the database`);
  document.getElementById('subscribeDataEntryForm').reset();
//   $('#subscribeOuterModal').modal('toggle');
  // $('#AckModal').modal('toggle');
}


async function getStudentRecords() {
  fetch('http://localhost:8088/getstudentlist')
    .then(getStudentsResponse => {
      return getStudentsResponse.json();
    })
    .then(getStudentsResponse => {
      console.log(getStudentsResponse);
      console.log(`Student list displayed...`);
    });

    window.open("http://localhost:8088/getstudentlist", "_blank"); 
}


/*
    async function getStudentRecord() { 
    // document.getElementById("fetchButton").click();
    let response = await fetch('http://localhost:8088/getstudentlist');
    let getStudents = await response.json();
      return getStudents;
    }
    getStudentRecord().then(getStudents =>{ 
      console.log(getStudents);
      console.log(`Student list displayed`);
    });

*/