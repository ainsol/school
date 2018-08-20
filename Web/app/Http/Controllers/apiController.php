<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;

class apiController 
{
     use AuthorizesRequests, DispatchesJobs, ValidatesRequests;
   
    public function __construct()
    {
        
    }
}
