<?php

// use Restserver\Libraries\REST_Controller;

defined('BASEPATH') OR exit('No direct script access allowed');

// Jika ada pesan "REST_Controller not found"
require APPPATH . 'libraries/REST_Controller.php';
require APPPATH . 'libraries/Format.php';


class Produk extends REST_Controller {

	private $folder_upload = 'uploads/';

    function all_get(){
        $get_produk = $this->db->query("
            SELECT
                *
				FROM tb_produk")->result();
       $this->response(
           array(
               "status" => "success",
               "result" => $get_produk
           )
       );
    }

    
}

/* End of file Pembeli.php */
/* Location: ./application/controllers/Pembeli.php */