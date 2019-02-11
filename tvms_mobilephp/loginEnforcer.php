<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $enforcer_email = $_POST['enforcer_email'];
    $enforcer_password = $_POST['enforcer_password'];
//
    require_once 'connect.php';

    $sql = "SELECT * FROM enforcer WHERE enforcer_email='$enforcer_email' ";

    $response = mysqli_query($conn, $sql);
//
    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);

        if ( password_verify($password, $row['enforcer_password']) ) {
            
            $index['enforcer_lname'] = $row['enforcer_lname'];
            $index['enforcer_email'] = $row['enforcer_email'];
            $index['enforcer_id'] = $row['enforcer_id'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    }

}

?>