<?php

include 'dbconn.php';
     $table = 'violators';
     $fields = array(
        'driver_id',
        'enforcer_id',
        'violations',
        'totalFee',
        'violator_date',
        'violator_address',
        'violator_desc',
        'transaction'
    );

	$driver_id = $_POST['driver_id'];
	$enforcer_id = $_POST['enforcer_id']; // hidden session
	$violations = $_POST['violations']; // array of violation
	$totalFee = $_POST['totalFee']; // sum of penalty
	$violator_date = $_POST['violator_date']; // date auto get
	$violator_address = $_POST['violator_address']; // address
	$violator_desc = $_POST['violator_desc']; // description 
	$transaction = $_POST['transaction']; // auto generated

	$data=array($driver_id ,$enforcer_id,$violations,$totalFee,$violator_date,$violator_address,$violator_desc,$transaction);

    $status=addRecord($data,$fields,$table);
    if ( $status ) {
        $result["success"] = "1";
        $result["message"] = "success";
        echo json_encode($result);
    } else {
        $result["success"] = "0";
        $result["message"] = "error";
        echo json_encode($result);
    }