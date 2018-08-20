<?php

namespace App\Http\Controllers\Api;
use App\Http\Controllers\apiController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LoginController extends apiController
{
   
   

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    
    public function login(Request $request)
    {
        // $user=\App\User::select("id","email","password","role_id","token")
        // ->where("email","=",$request->input("email"))
        // ->first();
        // if(
        // !empty($user) &&
        //  password_verify($request->input("password"),$user->password)
        //  )
        //  {
        //     return response()->json(
        //         ["message"=>"login successful",
        //         "data"=>$user,
        //         "status"=>200
        //     ],200);
        // }
        //     return response()->json(
        //         [
        //             "message"=>"login not successful","status"=>404
        //         ],404);


        if(Auth::attempt(['email' => $request->input('email'), 'password' => $request->input('password')])){ 
            $user = Auth::user(); 
            $success['token'] =  $user->createToken('MyApp')-> accessToken; 
            return response()->json(['success' => $success],200); 
        } 
        else{ 
            return response()->json(['error'=>'Unauthorised'], 401); 
        } 
    }
}
