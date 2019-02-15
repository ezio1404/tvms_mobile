<?php

 if ($_SERVER['REQUEST_METHOD']=='POST') {



    require_once 'connect.php';

    $sql = "SELECT * FROM agency";

    $response = mysqli_query($conn, $sql);

    //
    $result = array();
    $result['load'] = array();
    if ( mysqli_num_rows($response) > 0 ) {
        
	       while($row = $response->fetch_assoc()) {
            // $index['driver_lname'] = $row['driver_lname'];
            $index['agency_id'] = $row['agency_id'];
            $index['agency_name'] = $row['agency_name'];

            array_push($result['load'], $index);

           }
           
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

?>