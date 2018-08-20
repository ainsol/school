<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
//you only have to look for the url (/login) before this we have get,post,patch 
//methods to define type

Route::get('/login', "\App\Http\Controllers\Api\LoginController@login");
Route::group(['middleware' => 'auth:api'],function(){
//all methods after login will go here, you will be provieded an auth token for every login 
//this auth token will be used for fetching information from the api usage

});
