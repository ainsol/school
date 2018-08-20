<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\apiController;
use Illuminate\Http\Request;

class LoginController extends apiController
{
    private  $apikey="%&^$)@($(#)@($)@AS78:~@4";
   
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct(Request $request)
    {

         if($request->input("apiKey")!=$this->apikey)
        {
          
            return response()->json(["message"=>"Api key not provided","status"=>503],503);
        }
    
        
     //   $this->middleware('api');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    public function login(Request $request)
    {
        $user=\App\User::select("id","email","password","role_id")
        ->where("email","=",$request->input("email"))
        ->first();

        if(
        !empty($user) &&
         password_verify($request->input("password"),$user->password)
         )
         {
            return response()->json(
                ["message"=>"login successful",
                "data"=>$user,
                "status"=>200
            ],200);
        }
            return response()->json(
                [
                    "message"=>"login not successful","status"=>404
                ],404);
    }
}
