<?php
include 'dbconn.php';
     $table = 'services';
     $fields = array(
        'driver_id',
        'service_date',
        'service_address',
        'plateNo',
        'service_description',
    );
	$driver_id = $_POST['driver_id'];
	$service_date = $_POST['service_date'];
	$service_address = $_POST['service_address'];
	$plateNo = $_POST['plateNo'];
	$service_description = $_POST['service_description'];

	$data=array($driver_id,$service_date,$service_address,$plateNo ,$service_description);

		$status=addRecord($data,$fields,$table);
		echo json_encode($status);
