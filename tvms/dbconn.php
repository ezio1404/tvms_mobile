<?php

function conn(){
	try{
		return new PDO("mysql:hostname=localhost;dbname=tvms","root","");
	}catch(PDOException $e){
		echo $e->getMessage();
	}
}


function loginDriver($data, $fields) {
	$sql = "SELECT * FROM driver WHERE $fields[0] = ?";
	$stmt = conn()->prepare($sql);
	$stmt->execute(array($data[0]));
	if($stmt->rowCount() > 0) {
		$dbData = $stmt->fetch(PDO::FETCH_ASSOC);
		if(password_verify($data[1], $dbData['driver_password'])){
			return $dbData;
		} else {
			return array('status' => 'Invalid Credentials');
		}
	}
	else {
		return array('status' => 'Invalid Credentials');
	}
}
function loginEnforcer($data, $fields) {
	$sql = "SELECT * FROM enforcer WHERE $fields[0] = ?";
	$stmt = conn()->prepare($sql);
	$stmt->execute(array($data[0]));
	if($stmt->rowCount() > 0) {
		$dbData = $stmt->fetch(PDO::FETCH_ASSOC);
		if(password_verify($data[1], $dbData['enforcer_password'])){
			return $dbData;
		} else {
			return array('status' => 'Invalid Credentials');
		}
	}
	else {
		return array('status' => 'Invalid Credentials');
	}
}

    function addRecord($data,$fields,$table){
        $flds = implode(",",$fields);
        $val = array();
        foreach($data as $d)
        $val[] = "?";
        $values = implode(",",$val);
        // $sql = "INSERT INTO $table($flds) VALUES($values)";
        $stmt = conn()->prepare($sql);
       $ok= $stmt->execute($data);

       	if($stmt->rowCount() > 0) {
		return array('status' => 'exists');
	} else {
		$sql = "INSERT INTO $table($fld) VALUES($values)";
		$stmt = conn()->prepare($sql);
		$stmt->execute($data);
		$rows = $stmt->fetch(PDO::FETCH_ASSOC);
		if($stmt->rowCount() > 0) {
			return $rows;
		} else {
			return array('status' => 'failed');
		}
	}
        
	}
	
