package com.login_signup_screendesign_demo;

<<<<<<< HEAD
import java.net.URL;
=======
>>>>>>> e43f4a7dbca40972808132e3a122a3c809daf876
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
<<<<<<< HEAD
import com.android.volley.toolbox.StringRequest;
=======
>>>>>>> e43f4a7dbca40972808132e3a122a3c809daf876
import com.android.volley.toolbox.Volley;
import com.login_signup_screendesign_demo.Models.Settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

<<<<<<< HEAD
import org.json.JSONObject;

=======
import org.json.JSONException;
import org.json.JSONObject;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

>>>>>>> e43f4a7dbca40972808132e3a122a3c809daf876
public class Login_Fragment extends Fragment implements OnClickListener {
	private static View view;

	private static EditText emailid, password;
	private static Button loginButton;
	private static TextView forgotPassword, signUp;
	private static CheckBox show_hide_password;
	private static LinearLayout loginLayout;
	private static Animation shakeAnimation;
	private static FragmentManager fragmentManager;

<<<<<<< HEAD
	public static final String url="http://localhost:8000/api/login";
=======

>>>>>>> e43f4a7dbca40972808132e3a122a3c809daf876

	public Login_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.login_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initiate Views
	private void initViews() {
		fragmentManager = getActivity().getSupportFragmentManager();

		emailid = (EditText) view.findViewById(R.id.login_emailid);
		password = (EditText) view.findViewById(R.id.login_password);
		loginButton = (Button) view.findViewById(R.id.loginBtn);
		forgotPassword = (TextView) view.findViewById(R.id.forgot_password);
		signUp = (TextView) view.findViewById(R.id.createAccount);
		show_hide_password = (CheckBox) view
				.findViewById(R.id.show_hide_password);
		loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);

		// Load ShakeAnimation
		shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
				R.anim.shake);

		// Setting text selector over textviews
		XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			forgotPassword.setTextColor(csl);
			show_hide_password.setTextColor(csl);
			signUp.setTextColor(csl);
		} catch (Exception e) {
		}
	}

	// Set Listeners
	private void setListeners() {
		loginButton.setOnClickListener(this);
		forgotPassword.setOnClickListener(this);

		// Set check listener over checkbox for showing and hiding password
		show_hide_password
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton button,
							boolean isChecked) {

						// If it is checkec then show password else hide
						// password
						if (isChecked) {

							show_hide_password.setText(R.string.hide_pwd);// change
																			// checkbox
																			// text

							password.setInputType(InputType.TYPE_CLASS_TEXT);
							password.setTransformationMethod(HideReturnsTransformationMethod
									.getInstance());// show password
						} else {
							show_hide_password.setText(R.string.show_pwd);// change
																			// checkbox
																			// text

							password.setInputType(InputType.TYPE_CLASS_TEXT
									| InputType.TYPE_TEXT_VARIATION_PASSWORD);
							password.setTransformationMethod(PasswordTransformationMethod
									.getInstance());// hide password

						}

					}
				});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginBtn:
			checkValidation();

<<<<<<< HEAD
			// Instantiate the RequestQueue.
			RequestQueue queue = Volley.newRequestQueue(view.getContext());


// POST parameters
			Map<String, String> params = new HashMap<String, String>();
			params.put("tag", "test");

			JSONObject jsonObj = new JSONObject(params);

// Request a json response from the provided URL
			JsonObjectRequest jsonObjRequest = new JsonObjectRequest
					(Request.Method.POST, url, jsonObj, new Response.Listener<JSONObject>()
					{
						@Override
						public void onResponse(JSONObject response)
						{
							Toast.makeText(view.getContext(), response.toString(), Toast.LENGTH_SHORT).show();
						}
					},
							new Response.ErrorListener()
							{
								@Override
								public void onErrorResponse(VolleyError error)
								{
									Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
								}
							});

=======
			JSONObject obj = new JSONObject();

			try {
				obj.put("email", "admin@admin.com");
				obj.put("password", "password");
			} catch (JSONException e) {
				e.printStackTrace();
			}

		Uri.Builder urlBuild = Uri.parse(Settings.url)
					.buildUpon()
					.appendPath("login");

			String url = urlBuild.build().toString();
			JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
					(Request.Method.POST,url ,obj,new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {

//							try {

								Log.i("Shahid",response.toString());

//								String token=response.getJSONObject("token").toString();
//								Intent intent = new Intent(view.getContext(), MainActivity.class);
//								String message = token;
//								intent.putExtra(EXTRA_MESSAGE, message);
//								startActivity(intent);

//							} catch (JSONException e) {
//								e.printStackTrace();
//							}
						}
					},
							new Response.ErrorListener() {
								@Override
								public void onErrorResponse(VolleyError error) {
                                    Log.i("Shahid",error.toString());
								}
							}
					);
			Volley.newRequestQueue(view.getContext()).add(jsonObjectRequest);
>>>>>>> e43f4a7dbca40972808132e3a122a3c809daf876


			break;

		case R.id.forgot_password:

			// Replace forgot password fragment with animation
			fragmentManager
					.beginTransaction()
					.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
					.replace(R.id.frameContainer,
							new ForgotPassword_Fragment(),
							Utils.ForgotPassword_Fragment).commit();
			break;
		case R.id.createAccount:

			// Replace signup frgament with animation
			/*fragmentManager
					.beginTransaction()
					.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
					.replace(R.id.frameContainer, new SignUp_Fragment(),
							Utils.SignUp_Fragment).commit();
			break;*/
		}

	}

	// Check Validation before login
	private void checkValidation() {
		// Get email id and password
		String getEmailId = emailid.getText().toString();
		String getPassword = password.getText().toString();

		// Check patter for email id
		Pattern p = Pattern.compile(Utils.regEx);

		Matcher m = p.matcher(getEmailId);

		// Check for both field is empty or not
		if (getEmailId.equals("") || getEmailId.length() == 0
				|| getPassword.equals("") || getPassword.length() == 0) {
			loginLayout.startAnimation(shakeAnimation);
			new CustomToast().Show_Toast(getActivity(), view,
					"Enter both credentials.");

		}
		// Check if email id is valid or not
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");
		// Else do login and do your stuff
		else
			Toast.makeText(getActivity(), "Do Login.", Toast.LENGTH_SHORT)
					.show();

	}
}
