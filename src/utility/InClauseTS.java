/*
* Copyright (c) 2018 General Electric Company. All rights reserved.
*
* The copyright to the computer software herein is the property of
* General Electric Company. The software may be used and/or copied only
* with the written permission of General Electric Company or in accordance
* with the terms and conditions stipulated in the agreement/contract
* under which the software has been supplied.
*/
package utility;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.cert.CertificateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author ramveersingh
 */
public class InClauseTS {
	/**
	 * APPLICATION_JSON_CHARSET_UTF_8 :
	 */
	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8"; //$NON-NLS-1$

	/**
	 * @param args
	 *            :
	 */
	public static void main(String args[]) {
		/**
		 * Execute the use case from here
		 *
		 * Use Case 1 to 9 : ts.useCase1() Use Case 14 : ts.useCase14() Use Case
		 * 15 : ts.useCase15() Use Case 16 : same as Use case 15
		 *
		 */
		// System.out.println("-------------------Executing Query
		// ----------------------"); //$NON-NLS-1$
		InClauseTS ts = new InClauseTS();
		// System.out.println("Use case 1 final result:---------" +
		//ts.useCase14Solution(); // $NON-NLS-1$
		 ts.useCase15();
	}
/*****************************SOLUTION FOR USE CASE 1 TO 9*********************************************************************/
	/**
	 * Just call this method for use case 1. For use cases 2 to 9 we have to make some changes in Queries for these use case
	 * 
	 */
	private void useCase1Solution() {
		Connection c = getSqliteConn();
		if (c == null) {
			System.out.println("No connection to sqlite , exiting program"); //$NON-NLS-1$
			System.exit(0);
		}
		System.out.println("Opened database successfully"); //$NON-NLS-1$
		Statement stmt = null;
		try {
			/**
			 * clear pre-existing table
			 */
			stmt = c.createStatement();
			String sqlCommand = "DROP TABLE IF EXISTS 'reporting' "; //$NON-NLS-1$
			executeDeleteInsertQuery(stmt, sqlCommand);
			System.out.println("droped tables"); //$NON-NLS-1$
			/**
			 * create table and insert data coming from useCase1 method
			 */
			String insertQry = "CREATE TABLE IF NOT EXISTS reporting  (tagid CHAR(300) NOT NULL,day           INT    NOT NULL,v REAL)"; //$NON-NLS-1$
			executeDeleteInsertQuery(stmt, insertQry);
			List<FirstUseCaseVo> rs = useCase1();
			for (int i = 0; i < rs.size(); i++) {
				FirstUseCaseVo vo = rs.get(i);
				String insertQ = "VAlues( " + "'" + vo.getTagid() + "'" + "," + vo.getDay() + "," + vo.getV() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				String insertSql = "INSERT INTO reporting (tagid,day,v) " + insertQ; //$NON-NLS-1$
				executeDeleteInsertQuery(stmt, insertSql);
				System.out.println("inserting row no ----" + i); //$NON-NLS-1$
			}
			/**
			 * get group by data from the table
			 */
			ResultSet rsint = stmt.executeQuery(
					"SELECT tagid,day,v ,sum(v) as sumi,avg(v) as avgi from reporting group by day,tagid"); //$NON-NLS-1$
			JSONArray f = new JSONArray();
			while (rsint.next()) {
				JSONObject o = new JSONObject();
				o.put("tagid", rsint.getString("tagid")); //$NON-NLS-1$ //$NON-NLS-2$
				o.put("day", rsint.getInt("day")); //$NON-NLS-1$ //$NON-NLS-2$
				o.put("v", rsint.getDouble("v")); //$NON-NLS-1$ //$NON-NLS-2$
				o.put("sum", rsint.getDouble("sumi")); //$NON-NLS-1$ //$NON-NLS-2$
				o.put("avg", rsint.getDouble("avgi")); //$NON-NLS-1$ //$NON-NLS-2$
				f.put(o);
			}
			rsint.close();
			/**
			 * delete the table once we got the data
			 */
			stmt.executeUpdate(sqlCommand);
			System.out.println("droped tables"); //$NON-NLS-1$
			stmt.close();
			c.close();
			/**
			 * print the data
			 */
			System.out.println("final group by result is ----" + f); //$NON-NLS-1$
			System.out.println("------completed---------"); //$NON-NLS-1$
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*****************************SOLUTION FOR USE CASE 14*********************************************************************/
	/**
	 * Call this method for use case 14
	 */
	/**
	 * Use case 14 First get the tag list and then pass these tag lists to time
	 * series
	 * 
	 * @param headers
	 * @return
	 */
	private String useCase14() {
		/**
		 * Query NEED TO BE UPDATED based on instance name
		 */
		String tagListQuery = "select timeserieslink from reporting_tags360 tags, assetsuc_14v4 a where tags.q='name%3Dwell_status%3Aparent-%3Euri%3D%2Fassets%2F0335bde4-ea92-3ee9-aac7-65b51412bb0c%7Cparent-%3Euri%3D%2Fassets%2Fa3dcec31-3cd8-32fa-9373-b784b9563c15%7Cparent-%3Euri%3D%2Fassets%2F0de3ad7f-47f6-3b0b-9803-808f57a3e96e%7Cparent-%3Euri%3D%2Fassets%2Fd11667ae-b363-3533-a5f5-de3bcf77ac02%7Cparent-%3Euri%3D%2Fassets%2Fc920ff7b-7dd9-3f0d-b7df-4260d8e502af%7Cparent-%3Euri%3D%2Fassets%2F2d1cecee-f4de-3ff9-bdc5-a2b1a9bd69f5%7Cparent-%3Euri%3D%2Fassets%2F1bf63a1d-8466-364f-b573-d319e3fbec2d%7Cparent-%3Euri%3D%2Fassets%2F0763fb29-8110-3eb5-890c-1f13b8f1c97f%7Cparent-%3Euri%3D%2Fassets%2Fb47edb6c-b48f-3e9b-8191-8834b793a95a%7Cparent-%3Euri%3D%2Fassets%2F80273d10-d218-3ecb-a082-e409c9b13d27%7Cparent-%3Euri%3D%2Fassets%2Fdaa43d7d-0bef-3398-b357-40e9b9bce10c%7Cparent-%3Euri%3D%2Fassets%2Fad3442dc-2f62-3bde-9455-985f6dff065b%7Cparent-%3Euri%3D%2Fassets%2F0e5f0b9b-e7ca-3e5c-9c9e-178f7c6d54f6%7Cparent-%3Euri%3D%2Fassets%2F8a33534a-c227-3c43-9b70-8c11414143e6%7Cparent-%3Euri%3D%2Fassets%2Fa98dddb2-c2cb-3eca-ac6b-3198c30bb172%7Cparent-%3Euri%3D%2Fassets%2Ff2533103-271a-38e1-9653-1066fcffd071%7Cparent-%3Euri%3D%2Fassets%2Fba34704f-d67e-3aef-8893-658e12997fbe%7Cparent-%3Euri%3D%2Fassets%2Fe6f24397-67eb-3914-9949-7c2f966c9f9c%7Cparent-%3Euri%3D%2Fassets%2F69d03425-3326-3e12-8df9-6cc6f3c9f60c%7Cparent-%3Euri%3D%2Fassets%2Feb87ad6b-86dd-3f58-b55d-06053c62ca2d%7Cparent-%3Euri%3D%2Fassets%2F5d52245b-2afe-3d31-a465-10da7e376410%7Cparent-%3Euri%3D%2Fassets%2F3dc0fe84-302c-3237-b21a-172dbcd28c76%7Cparent-%3Euri%3D%2Fassets%2Fe33de3ca-77c3-3193-b7b5-6c392af84f2c%7Cparent-%3Euri%3D%2Fassets%2F36da00eb-f08e-3116-988b-9ad84a853668%7Cparent-%3Euri%3D%2Fassets%2F66ed13d9-b786-3d96-ae66-6b866eaefa26%7Cparent-%3Euri%3D%2Fassets%2F0a42c30f-11d1-3c38-b6a0-93d55025194e%7Cparent-%3Euri%3D%2Fassets%2F4cb41fac-28bd-359d-9928-1e0c73a4478f%7Cparent-%3Euri%3D%2Fassets%2Ffae8c494-21df-310d-89e1-4e517e15fab8%7Cparent-%3Euri%3D%2Fassets%2F32b96679-7bff-34b5-9d1c-88adcccabec6%7Cparent-%3Euri%3D%2Fassets%2F91081525-f460-312b-8824-dcfb33fc48c7%7Cparent-%3Euri%3D%2Fassets%2Fc05f8ab0-43a8-34c0-85a0-3246654452b9%7Cparent-%3Euri%3D%2Fassets%2Fcbe97114-9833-386c-b82c-4e4f60482ded%7Cparent-%3Euri%3D%2Fassets%2Fff76956c-c1b7-3731-afa5-45a6349febeb%7Cparent-%3Euri%3D%2Fassets%2Fdd398cef-8cd1-35f3-925e-48d1df9d563a%7Cparent-%3Euri%3D%2Fassets%2F831cc072-7480-3fbf-a32b-cb55fa4d1cfa%7Cparent-%3Euri%3D%2Fassets%2F427a3faa-f0d0-3624-a247-9cb61e770c3f%7Cparent-%3Euri%3D%2Fassets%2F1e312ed1-f06d-3a48-af94-51674784f6b9%7Cparent-%3Euri%3D%2Fassets%2F34b960b3-0f34-381f-93c3-babdf8059619%7Cparent-%3Euri%3D%2Fassets%2F7f8584ea-dad8-3572-9471-2fc28afa6203%7Cparent-%3Euri%3D%2Fassets%2F0b0602c8-a356-3888-b1cc-e9174a0a092e%7Cparent-%3Euri%3D%2Fassets%2Fdf5b003d-3835-372c-be28-42e5c6dbebae%7Cparent-%3Euri%3D%2Fassets%2F5708fb60-a68c-3df0-aaf4-3203ad9fe1ab%7Cparent-%3Euri%3D%2Fassets%2F86925017-b887-3d87-aebb-898afb7cbe61%7Cparent-%3Euri%3D%2Fassets%2F933f3967-5c14-3cdf-b8bb-cdfec13892be%7Cparent-%3Euri%3D%2Fassets%2F7a88f7a7-16ed-3dd2-b6b9-2e5b57892b46%7Cparent-%3Euri%3D%2Fassets%2F3d85c7ca-c12c-371d-9cd0-18e14079f1c7%7Cparent-%3Euri%3D%2Fassets%2Fc2084958-49d7-3b2f-8301-da3ec4fd551f%7Cparent-%3Euri%3D%2Fassets%2Fb566aaa7-abcb-322a-9c15-2f50c4a63d59%7Cparent-%3Euri%3D%2Fassets%2F2c3a2c42-c09d-3988-9024-2ad3c4eac5f4%7Cparent-%3Euri%3D%2Fassets%2F3fdb19ce-923c-3c20-9187-b47c95611778%7Cparent-%3Euri%3D%2Fassets%2Fd01e6102-7eac-39c3-b3a9-1a03d1187edf%7Cparent-%3Euri%3D%2Fassets%2Ffcffcaf3-f642-332c-b940-e6b8256c6e6e%7Cparent-%3Euri%3D%2Fassets%2Fddd7e371-9615-3ab7-97fa-3c46f7fefcef%7Cparent-%3Euri%3D%2Fassets%2Fa53b3f76-792a-325f-9392-9ca711ec66e4%7Cparent-%3Euri%3D%2Fassets%2F95304dbd-74a9-330e-a6c9-c249ac7fb4ea%7Cparent-%3Euri%3D%2Fassets%2Faea48f75-10d8-3b3e-b41f-70d0279c6128%7Cparent-%3Euri%3D%2Fassets%2F4f6621e8-d40c-3682-8c34-81b8de810445%7Cparent-%3Euri%3D%2Fassets%2F049b0909-b26e-367f-a7c0-b075c25462b4%7Cparent-%3Euri%3D%2Fassets%2Fe59d28c0-6d73-34fb-9fc5-9a36ec1c0bba%7Cparent-%3Euri%3D%2Fassets%2Fb013879a-a799-335f-b4d1-cd1e19cec535%7Cparent-%3Euri%3D%2Fassets%2Fd7918058-ca8e-3b5f-8f34-1d4ce915ceaf' and a.uri=tags.monitoredEntityUri and a.lifttype='ESP' and a.q='uri%3D%2Fassets%2F0335bde4-ea92-3ee9-aac7-65b51412bb0c%7Curi%3D%2Fassets%2Fa3dcec31-3cd8-32fa-9373-b784b9563c15%7Curi%3D%2Fassets%2F0de3ad7f-47f6-3b0b-9803-808f57a3e96e%7Curi%3D%2Fassets%2Fd11667ae-b363-3533-a5f5-de3bcf77ac02%7Curi%3D%2Fassets%2Fc920ff7b-7dd9-3f0d-b7df-4260d8e502af%7Curi%3D%2Fassets%2F2d1cecee-f4de-3ff9-bdc5-a2b1a9bd69f5%7Curi%3D%2Fassets%2F1bf63a1d-8466-364f-b573-d319e3fbec2d%7Curi%3D%2Fassets%2F0763fb29-8110-3eb5-890c-1f13b8f1c97f%7Curi%3D%2Fassets%2Fb47edb6c-b48f-3e9b-8191-8834b793a95a%7Curi%3D%2Fassets%2F80273d10-d218-3ecb-a082-e409c9b13d27%7Curi%3D%2Fassets%2Fdaa43d7d-0bef-3398-b357-40e9b9bce10c%7Curi%3D%2Fassets%2Fad3442dc-2f62-3bde-9455-985f6dff065b%7Curi%3D%2Fassets%2F0e5f0b9b-e7ca-3e5c-9c9e-178f7c6d54f6%7Curi%3D%2Fassets%2F8a33534a-c227-3c43-9b70-8c11414143e6%7Curi%3D%2Fassets%2Fa98dddb2-c2cb-3eca-ac6b-3198c30bb172%7Curi%3D%2Fassets%2Ff2533103-271a-38e1-9653-1066fcffd071%7Curi%3D%2Fassets%2Fba34704f-d67e-3aef-8893-658e12997fbe%7Curi%3D%2Fassets%2Fe6f24397-67eb-3914-9949-7c2f966c9f9c%7Curi%3D%2Fassets%2F69d03425-3326-3e12-8df9-6cc6f3c9f60c%7Curi%3D%2Fassets%2Feb87ad6b-86dd-3f58-b55d-06053c62ca2d%7Curi%3D%2Fassets%2F5d52245b-2afe-3d31-a465-10da7e376410%7Curi%3D%2Fassets%2F3dc0fe84-302c-3237-b21a-172dbcd28c76%7Curi%3D%2Fassets%2Fe33de3ca-77c3-3193-b7b5-6c392af84f2c%7Curi%3D%2Fassets%2F36da00eb-f08e-3116-988b-9ad84a853668%7Curi%3D%2Fassets%2F66ed13d9-b786-3d96-ae66-6b866eaefa26%7Curi%3D%2Fassets%2F0a42c30f-11d1-3c38-b6a0-93d55025194e%7Curi%3D%2Fassets%2F4cb41fac-28bd-359d-9928-1e0c73a4478f%7Curi%3D%2Fassets%2Ffae8c494-21df-310d-89e1-4e517e15fab8%7Curi%3D%2Fassets%2F32b96679-7bff-34b5-9d1c-88adcccabec6%7Curi%3D%2Fassets%2F91081525-f460-312b-8824-dcfb33fc48c7%7Curi%3D%2Fassets%2Fc05f8ab0-43a8-34c0-85a0-3246654452b9%7Curi%3D%2Fassets%2Fcbe97114-9833-386c-b82c-4e4f60482ded%7Curi%3D%2Fassets%2Fff76956c-c1b7-3731-afa5-45a6349febeb%7Curi%3D%2Fassets%2Fdd398cef-8cd1-35f3-925e-48d1df9d563a%7Curi%3D%2Fassets%2F831cc072-7480-3fbf-a32b-cb55fa4d1cfa%7Curi%3D%2Fassets%2F427a3faa-f0d0-3624-a247-9cb61e770c3f%7Curi%3D%2Fassets%2F1e312ed1-f06d-3a48-af94-51674784f6b9%7Curi%3D%2Fassets%2F34b960b3-0f34-381f-93c3-babdf8059619%7Curi%3D%2Fassets%2F7f8584ea-dad8-3572-9471-2fc28afa6203%7Curi%3D%2Fassets%2F0b0602c8-a356-3888-b1cc-e9174a0a092e%7Curi%3D%2Fassets%2Fdf5b003d-3835-372c-be28-42e5c6dbebae%7Curi%3D%2Fassets%2F5708fb60-a68c-3df0-aaf4-3203ad9fe1ab%7Curi%3D%2Fassets%2F86925017-b887-3d87-aebb-898afb7cbe61%7Curi%3D%2Fassets%2F933f3967-5c14-3cdf-b8bb-cdfec13892be%7Curi%3D%2Fassets%2F7a88f7a7-16ed-3dd2-b6b9-2e5b57892b46%7Curi%3D%2Fassets%2F3d85c7ca-c12c-371d-9cd0-18e14079f1c7%7Curi%3D%2Fassets%2Fc2084958-49d7-3b2f-8301-da3ec4fd551f%7Curi%3D%2Fassets%2Fb566aaa7-abcb-322a-9c15-2f50c4a63d59%7Curi%3D%2Fassets%2F2c3a2c42-c09d-3988-9024-2ad3c4eac5f4%7Curi%3D%2Fassets%2F3fdb19ce-923c-3c20-9187-b47c95611778%7Curi%3D%2Fassets%2Fd01e6102-7eac-39c3-b3a9-1a03d1187edf%7Curi%3D%2Fassets%2Ffcffcaf3-f642-332c-b940-e6b8256c6e6e%7Curi%3D%2Fassets%2Fddd7e371-9615-3ab7-97fa-3c46f7fefcef%7Curi%3D%2Fassets%2Fa53b3f76-792a-325f-9392-9ca711ec66e4%7Curi%3D%2Fassets%2F95304dbd-74a9-330e-a6c9-c249ac7fb4ea%7Curi%3D%2Fassets%2Faea48f75-10d8-3b3e-b41f-70d0279c6128%7Curi%3D%2Fassets%2F4f6621e8-d40c-3682-8c34-81b8de810445%7Curi%3D%2Fassets%2F049b0909-b26e-367f-a7c0-b075c25462b4%7Curi%3D%2Fassets%2Fe59d28c0-6d73-34fb-9fc5-9a36ec1c0bba%7Curi%3D%2Fassets%2Fb013879a-a799-335f-b4d1-cd1e19cec535%7Curi%3D%2Fassets%2Fd7918058-ca8e-3b5f-8f34-1d4ce915ceaf'"; //$NON-NLS-1$
		JSONObject tagQueryPayLoad = getQueryPayload(tagListQuery);
		/**
		 * url NEED TO BE UPDATED based on instance name
		 */
		String url = "https://fat01.na03.bhge.com/v1/query"; //$NON-NLS-1$
		HashMap<String, String> header = getQueryReqHeaders();
		List<String> finalList = getTagList(url, tagQueryPayLoad.toString(), header);
		System.out.println("Total tags are -  -- - - - - " + finalList.size()); //$NON-NLS-1$
		/**
		 * Now execute the second Query to get the data from TS while dividing
		 * the tags in 40 groups each
		 */
		int k = 0;
		JSONArray array = new JSONArray();
		while (k < finalList.size()) {
			int maxCount = k + 40 > finalList.size() ? finalList.size() : k + 40;
			List<String> subList = finalList.subList(k, maxCount);
			String commString = String.join(",", subList); //$NON-NLS-1$
			JSONObject singleObject = new JSONObject();
			// query_string NEED TO BE UPDATED
			String queryString = "select tagid , max(tmp) as timeNew,count(*),lifttype from (select tagid ,from_iso8601_timestamp(ts) as tmp  ,a.lifttype as lifttype,day(from_iso8601_timestamp(ts)) as day from tstest3602,assetsuc_14v4 a where tagList=" //$NON-NLS-1$
			+ "'"  //$NON-NLS-1$
			+ commString + "'"  //$NON-NLS-1$
			+" and v= 102 and a.lifttype in( 'ESP','RLS') and  a.q='uri%3D%2Fassets%2F0335bde4-ea92-3ee9-aac7-65b51412bb0c%7Curi%3D%2Fassets%2Fa3dcec31-3cd8-32fa-9373-b784b9563c15%7Curi%3D%2Fassets%2F0de3ad7f-47f6-3b0b-9803-808f57a3e96e%7Curi%3D%2Fassets%2Fd11667ae-b363-3533-a5f5-de3bcf77ac02%7Curi%3D%2Fassets%2Fc920ff7b-7dd9-3f0d-b7df-4260d8e502af%7Curi%3D%2Fassets%2F2d1cecee-f4de-3ff9-bdc5-a2b1a9bd69f5%7Curi%3D%2Fassets%2F1bf63a1d-8466-364f-b573-d319e3fbec2d%7Curi%3D%2Fassets%2F0763fb29-8110-3eb5-890c-1f13b8f1c97f%7Curi%3D%2Fassets%2Fb47edb6c-b48f-3e9b-8191-8834b793a95a%7Curi%3D%2Fassets%2F80273d10-d218-3ecb-a082-e409c9b13d27%7Curi%3D%2Fassets%2Fdaa43d7d-0bef-3398-b357-40e9b9bce10c%7Curi%3D%2Fassets%2Fad3442dc-2f62-3bde-9455-985f6dff065b%7Curi%3D%2Fassets%2F0e5f0b9b-e7ca-3e5c-9c9e-178f7c6d54f6%7Curi%3D%2Fassets%2F8a33534a-c227-3c43-9b70-8c11414143e6%7Curi%3D%2Fassets%2Fa98dddb2-c2cb-3eca-ac6b-3198c30bb172%7Curi%3D%2Fassets%2Ff2533103-271a-38e1-9653-1066fcffd071%7Curi%3D%2Fassets%2Fba34704f-d67e-3aef-8893-658e12997fbe%7Curi%3D%2Fassets%2Fe6f24397-67eb-3914-9949-7c2f966c9f9c%7Curi%3D%2Fassets%2F69d03425-3326-3e12-8df9-6cc6f3c9f60c%7Curi%3D%2Fassets%2Feb87ad6b-86dd-3f58-b55d-06053c62ca2d%7Curi%3D%2Fassets%2F5d52245b-2afe-3d31-a465-10da7e376410%7Curi%3D%2Fassets%2F3dc0fe84-302c-3237-b21a-172dbcd28c76%7Curi%3D%2Fassets%2Fe33de3ca-77c3-3193-b7b5-6c392af84f2c%7Curi%3D%2Fassets%2F36da00eb-f08e-3116-988b-9ad84a853668%7Curi%3D%2Fassets%2F66ed13d9-b786-3d96-ae66-6b866eaefa26%7Curi%3D%2Fassets%2F0a42c30f-11d1-3c38-b6a0-93d55025194e%7Curi%3D%2Fassets%2F4cb41fac-28bd-359d-9928-1e0c73a4478f%7Curi%3D%2Fassets%2Ffae8c494-21df-310d-89e1-4e517e15fab8%7Curi%3D%2Fassets%2F32b96679-7bff-34b5-9d1c-88adcccabec6%7Curi%3D%2Fassets%2F91081525-f460-312b-8824-dcfb33fc48c7%7Curi%3D%2Fassets%2Fc05f8ab0-43a8-34c0-85a0-3246654452b9%7Curi%3D%2Fassets%2Fcbe97114-9833-386c-b82c-4e4f60482ded%7Curi%3D%2Fassets%2Fff76956c-c1b7-3731-afa5-45a6349febeb%7Curi%3D%2Fassets%2Fdd398cef-8cd1-35f3-925e-48d1df9d563a%7Curi%3D%2Fassets%2F831cc072-7480-3fbf-a32b-cb55fa4d1cfa%7Curi%3D%2Fassets%2F427a3faa-f0d0-3624-a247-9cb61e770c3f%7Curi%3D%2Fassets%2F1e312ed1-f06d-3a48-af94-51674784f6b9%7Curi%3D%2Fassets%2F34b960b3-0f34-381f-93c3-babdf8059619%7Curi%3D%2Fassets%2F7f8584ea-dad8-3572-9471-2fc28afa6203%7Curi%3D%2Fassets%2F0b0602c8-a356-3888-b1cc-e9174a0a092e%7Curi%3D%2Fassets%2Fdf5b003d-3835-372c-be28-42e5c6dbebae%7Curi%3D%2Fassets%2F5708fb60-a68c-3df0-aaf4-3203ad9fe1ab%7Curi%3D%2Fassets%2F86925017-b887-3d87-aebb-898afb7cbe61%7Curi%3D%2Fassets%2F933f3967-5c14-3cdf-b8bb-cdfec13892be%7Curi%3D%2Fassets%2F7a88f7a7-16ed-3dd2-b6b9-2e5b57892b46%7Curi%3D%2Fassets%2F3d85c7ca-c12c-371d-9cd0-18e14079f1c7%7Curi%3D%2Fassets%2Fc2084958-49d7-3b2f-8301-da3ec4fd551f%7Curi%3D%2Fassets%2Fb566aaa7-abcb-322a-9c15-2f50c4a63d59%7Curi%3D%2Fassets%2F2c3a2c42-c09d-3988-9024-2ad3c4eac5f4%7Curi%3D%2Fassets%2F3fdb19ce-923c-3c20-9187-b47c95611778%7Curi%3D%2Fassets%2Fd01e6102-7eac-39c3-b3a9-1a03d1187edf%7Curi%3D%2Fassets%2Ffcffcaf3-f642-332c-b940-e6b8256c6e6e%7Curi%3D%2Fassets%2Fddd7e371-9615-3ab7-97fa-3c46f7fefcef%7Curi%3D%2Fassets%2Fa53b3f76-792a-325f-9392-9ca711ec66e4%7Curi%3D%2Fassets%2F95304dbd-74a9-330e-a6c9-c249ac7fb4ea%7Curi%3D%2Fassets%2Faea48f75-10d8-3b3e-b41f-70d0279c6128%7Curi%3D%2Fassets%2F4f6621e8-d40c-3682-8c34-81b8de810445%7Curi%3D%2Fassets%2F049b0909-b26e-367f-a7c0-b075c25462b4%7Curi%3D%2Fassets%2Fe59d28c0-6d73-34fb-9fc5-9a36ec1c0bba%7Curi%3D%2Fassets%2Fb013879a-a799-335f-b4d1-cd1e19cec535%7Curi%3D%2Fassets%2Fd7918058-ca8e-3b5f-8f34-1d4ce915ceaf' and operation='raw' and startTime='365d-ago' group by tagid,a.lifttype,from_iso8601_timestamp(ts)) group by tagid,lifttype  order by max (tmp)"; //$NON-NLS-1$
			singleObject.put("query_string", queryString); //$NON-NLS-1$
			singleObject.put("cache_control_max_age", "0"); //$NON-NLS-1$ //$NON-NLS-2$
			array.put(singleObject);
			k = k + 40;
			System.out.println("Query 14 -----------------"+queryString); //$NON-NLS-1$
		}
		JSONObject bulkReq = new JSONObject();
		bulkReq.put("queries", array); //$NON-NLS-1$
		bulkReq.put("mergeResponse", true); //$NON-NLS-1$
		/**
		 * Now execute the bulk query bulkUrl NEED TO BE UPDATED
		 */
		String bulkUrl = "https://fat01.na03.bhge.com/v1/query/bulkquery"; //$NON-NLS-1$
		String secondQueryres = null;
		try {
			secondQueryres = executeQuery(bulkUrl, bulkReq.toString(), header);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		System.out.println("Use case 14 result ---------" +secondQueryres); //$NON-NLS-1$
		return secondQueryres;
	}
	
	
	/*****************************SOLUTION FOR USE CASE 15,16*********************************************************************/
	/**
	 * Use case 15 Use case 16 can also be solved using this with minor changes
	 * 
	 * @param headers
	 * @return : 
	 */
	private String useCase15() {
		/**
		 * Get the tagList
		 */
		String tagListQuery = "select timeserieslink from reporting_tags360 tags  where tags.q='name%3DMOTOR-CURRENT%7Cname%3DMOTOR-TEMPERATURE%7Cname%3DWHP%3Aparent-%3Euri%3D%2Fassets%2Fe79e0a6d-0fa0-32f8-b5f3-e0cff84e44f3%7Cparent-%3Euri%3D%2Fassets%2Ffb141902-0f3f-3ee1-b6e5-d52f7648f7d7'"; //$NON-NLS-1$
		JSONObject tagQueryPayLoad = getQueryPayload(tagListQuery);
		String url = "https://fat01.na03.bhge.com/v1/query"; //$NON-NLS-1$
		HashMap<String, String> header = getQueryReqHeaders();
		List<String> finalList = getTagList(url, tagQueryPayLoad.toString(), header);
		/**
		 * Now execute the second Query to get the data from TS while dividing
		 * the tags in 40 groups each
		 */
		int k = 0;
		JSONArray array = new JSONArray();
		while (k < finalList.size()) {
			int maxCount = k + 40 > finalList.size() ? finalList.size() : k + 40;
			List<String> subList = finalList.subList(k, maxCount);
			String commString = String.join(",", subList); //$NON-NLS-1$
			JSONObject singleObject = new JSONObject();
			// query_string NEED TO BE UPDATED
			singleObject.put("query_string", //$NON-NLS-1$
					"select tagid,day(from_iso8601_timestamp(ts)) as day,a.name as name,count(*) as total  from tstest3602 ,reporting_tags360 a  where tagList=" //$NON-NLS-1$
							+ "'" //$NON-NLS-1$
							+ commString + "'" //$NON-NLS-1$
							+ " and operation='raw' and startTime='365d-ago' and a.q='name%3DMOTOR-CURRENT%7Cname%3DMOTOR-TEMPERATURE%7Cname%3DWHP%3Aparent-%3Euri%3D%2Fassets%2Fe79e0a6d-0fa0-32f8-b5f3-e0cff84e44f3%7Cparent-%3Euri%3D%2Fassets%2Ffb141902-0f3f-3ee1-b6e5-d52f7648f7d7' group by tagid,day(from_iso8601_timestamp(ts)) ,name"); //$NON-NLS-1$
			singleObject.put("cache_control_max_age", "0"); //$NON-NLS-1$ //$NON-NLS-2$
			array.put(singleObject);
			k = k + 40;
		}
		JSONObject bulkReq = new JSONObject();
		bulkReq.put("queries", array); //$NON-NLS-1$
		bulkReq.put("mergeResponse", true); //$NON-NLS-1$
		/**
		 * Now execute the bulk query bulkUrl NEED TO BE UPDATED
		 */
		String bulkUrl = "https://fat01.na03.bhge.com/v1/query/bulkquery"; //$NON-NLS-1$
		String secondQueryres = null;
		try {
			secondQueryres = executeQuery(bulkUrl, bulkReq.toString(), header);
			System.out.println("Executed use case 15 ,  result is -------" + secondQueryres); //$NON-NLS-1$
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return secondQueryres;
	}
	
	
	

	/**
	 * This method will execute the APIs required for use cases 1 to 9 This will
	 * be used by useCase1Solution method to get the final result
	 * 
	 * @return : List<FirstUseCaseVo>
	 */
	private List<FirstUseCaseVo> useCase1() {
		/**
		 * Query service URL url NEED TO BE UPDATED
		 */
		String url = "https://fat01.na03.bhge.com/v1/query"; //$NON-NLS-1$
		/**
		 * Query service Headers
		 */
		InClauseTS ts = new InClauseTS();
		HashMap<String, String> header = ts.getQueryReqHeaders();
		/**
		 * Query NEED TO BE UPDATED based on instance name
		 */
		String firstQuery = "select timeserieslink from reporting_tags360 tags  where tags.q='name%3DMOTOR-CURRENT%3Aparent-%3Euri%3D%2Fassets%2Fe79e0a6d-0fa0-32f8-b5f3-e0cff84e44f3%7Cparent-%3Euri%3D%2Fassets%2Ffb141902-0f3f-3ee1-b6e5-d52f7648f7d7%7Cparent-%3Euri%3D%2Fassets%2Fc964ff5e-d709-3210-b71a-351d34d631d0%7Cparent-%3Euri%3D%2Fassets%2F33189856-8fb2-344a-ba5f-230fc48510bd'"; //$NON-NLS-1$
		JSONObject firstQueryPayload = ts.getQueryPayload(firstQuery);
		/**
		 * Execute First Query to get the taglist
		 */
		List<String> finalList = ts.getTagList(url, firstQueryPayload.toString(), header);
		/**
		 * Executing second Query We will make bulk query request based on
		 * tag-list , in one query there can be at max 40 tags,using bulk query
		 * we will execute these queries Asynchronously and merge the response
		 */
		System.out.println("----------executing second query ---------------"); //$NON-NLS-1$
		int k = 0;
		JSONArray array = new JSONArray();
		while (k < finalList.size()) {
			int maxCount = k + 40 > finalList.size() ? finalList.size() : k + 40;
			List<String> subList = finalList.subList(k, maxCount);
			String commString = String.join(",", subList); //$NON-NLS-1$
			JSONObject singleObject = new JSONObject();
			// query_string NEED TO BE UPDATED
			// singleObject.put("query_string", //$NON-NLS-1$
			// "select tagid,day(from_iso8601_timestamp(ts)) as day, sum(v) as
			// dailysum from tstest360 where tagList=" //$NON-NLS-1$
			// + "'" //$NON-NLS-1$
			// + commString + "'" //$NON-NLS-1$
			// + "and operation='raw' and startTime='365d-ago' group by tagid,
			// day(from_iso8601_timestamp(ts))"); //$NON-NLS-1$
			//
			String q = "select tagid,day(from_iso8601_timestamp(ts)) as day, v  from tstest3602 where tagList=" + "'" //$NON-NLS-1$ //$NON-NLS-2$
					+ commString + "'" + "and operation='raw' and startTime='365d-ago'"; //$NON-NLS-1$ //$NON-NLS-2$
			singleObject.put("query_string", q); //$NON-NLS-1$

			singleObject.put("cache_control_max_age", "0"); //$NON-NLS-1$ //$NON-NLS-2$
			array.put(singleObject);
			k = k + 40;
		}
		JSONObject bulkReq = new JSONObject();
		bulkReq.put("queries", array); //$NON-NLS-1$
		bulkReq.put("mergeResponse", true); //$NON-NLS-1$
		/**
		 * Now execute the bulk query bulkUrl NEED TO BE UPDATED
		 */
		String bulkUrl = "https://fat01.na03.bhge.com/v1/query/bulkquery"; //$NON-NLS-1$
		String secondQueryres = null;
		try {
			secondQueryres = ts.executeQuery(bulkUrl, bulkReq.toString(), header);
			System.out.println("second query result-------" + secondQueryres); //$NON-NLS-1$
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return getkeyValueForUC1(secondQueryres);
	}

	/**
	 * Get Key-value pairs of the result
	 * 
	 * @param result
	 * @return
	 */
	private List<FirstUseCaseVo> getkeyValueForUC1(String result) {
		JSONObject root = new JSONObject(result);
		List<FirstUseCaseVo> fullResult = new ArrayList<FirstUseCaseVo>();
		JSONArray data = root.getJSONArray("data"); //$NON-NLS-1$
		for (int i = 0; i < root.getJSONArray("data").length(); i++) { //$NON-NLS-1$
			JSONObject temp = new JSONObject();
			for (int j = 0; j < root.getJSONArray("columns").length(); j++) { //$NON-NLS-1$
				JSONObject t = (JSONObject) root.getJSONArray("columns").get(j); //$NON-NLS-1$
				JSONArray r = (JSONArray) root.getJSONArray("data").get(i); //$NON-NLS-1$
				temp.put(t.get("name").toString(), r.get(j)); //$NON-NLS-1$
			}
			Gson gson = new Gson();
			FirstUseCaseVo name = gson.fromJson(temp.toString(), FirstUseCaseVo.class);
			fullResult.add(name);
		}
		System.out.println("Resut:---" + fullResult.toString()); //$NON-NLS-1$
		return fullResult;
	}


	/**
	 * This will execute the queries executeQuery
	 *
	 * @param url
	 *            :
	 * @param payload
	 *            :
	 * @param headers
	 *            :
	 * @return :
	 * @throws Exception
	 *             :
	 */
	private String executeQuery(String url, String payload, HashMap<String, String> headers) throws Exception {
		MediaType json = MediaType.parse(APPLICATION_JSON_CHARSET_UTF_8);
		RequestBody rb = RequestBody.create(json, payload);
		Headers headers2 = Headers.of(headers);
		Request request = new Request.Builder().url(url).post(rb).headers(headers2).build();
		Response response = makeHttpCall(request);
		String res = response.body().string();
		return res;
	}

	/**
	 * create HTTP request object
	 *
	 * @param request
	 *            : request
	 * @return : Response
	 * @throws Exception
	 *             : Exception
	 */
	public Response makeHttpCall(Request request) throws Exception {
		OkHttpClient client = getHttpClient();
		try {
			return client == null ? null : client.newCall(request).execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Exception while making okhttp client"); //$NON-NLS-1$
		}
	}

	/**
	 * getHttpClient
	 *
	 * @return : OkHttpClient
	 */
	public OkHttpClient getHttpClient() {
		OkHttpClient client = null;
		try {
			final TrustManager[] trustAllCerts = getTrustManager();
			final SSLContext sslContext = SSLContext.getInstance("SSL"); //$NON-NLS-1$
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			OkHttpClient.Builder builder = new OkHttpClient.Builder();
			builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
			builder.hostnameVerifier(getHostnameVerifier());
			builder.connectTimeout(200, TimeUnit.SECONDS);
			builder.writeTimeout(200, TimeUnit.SECONDS);
			builder.readTimeout(200, TimeUnit.SECONDS);
			builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("sjc1intproxy01.crd.ge.com", 8080))); //$NON-NLS-1$
			client = builder.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	private TrustManager[] getTrustManager() {
		TrustManager[] trustManager = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
					throws CertificateException {
				// accept all clients
			}

			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
					throws CertificateException {
				// accept all clients
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}
		} };
		return trustManager;
	}

	private HostnameVerifier getHostnameVerifier() {
		HostnameVerifier hostnameVerifier = (hostname, session) -> true;
		return hostnameVerifier;
	}

	/**
	 * Common method to get the Query payload
	 *
	 * @param queryString
	 * @return
	 */
	private JSONObject getQueryPayload(String queryString) {
		JSONObject firstQueryPayload = new JSONObject();
		firstQueryPayload.put("query_string", //$NON-NLS-1$
				queryString);
		firstQueryPayload.put("cache_control_max_age", "0"); //$NON-NLS-1$ //$NON-NLS-2$
		return firstQueryPayload;
	}

	/**
	 * This is the method to get the common headers to execute the query
	 *
	 * @return :
	 */
	private HashMap<String, String> getQueryReqHeaders() {
		HashMap<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json"); //$NON-NLS-1$ //$NON-NLS-2$
		// Authorization NEED TO BE UPDATED
		header.put("Authorization", //$NON-NLS-1$
				"Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiJlMjFjMTNiMGMwYjU0MDdjYjYxNTE1YmI1ZTE3YWZiNCIsInN1YiI6ImQ0Y2UwYzFmLTk3NTctNDllMS1hOGUxLThkYzhjZWUzYzdjNCIsInNjb3BlIjpbInBhc3N3b3JkLndyaXRlIiwib3BlbmlkIl0sImNsaWVudF9pZCI6ImluZ2VzdG9yLjI2YjMwNWVjLWY4MDEtNGU3Ni1iMDNhLWVmNDA5NDAzNTQ2ZS4zNTlhODJmNi01MDBhLTRmMjctYjYzYS02YWRmYzFlODE5ZjEiLCJjaWQiOiJpbmdlc3Rvci4yNmIzMDVlYy1mODAxLTRlNzYtYjAzYS1lZjQwOTQwMzU0NmUuMzU5YTgyZjYtNTAwYS00ZjI3LWI2M2EtNmFkZmMxZTgxOWYxIiwiYXpwIjoiaW5nZXN0b3IuMjZiMzA1ZWMtZjgwMS00ZTc2LWIwM2EtZWY0MDk0MDM1NDZlLjM1OWE4MmY2LTUwMGEtNGYyNy1iNjNhLTZhZGZjMWU4MTlmMSIsImdyYW50X3R5cGUiOiJwYXNzd29yZCIsInVzZXJfaWQiOiJkNGNlMGMxZi05NzU3LTQ5ZTEtYThlMS04ZGM4Y2VlM2M3YzQiLCJvcmlnaW4iOiJ1YWEiLCJ1c2VyX25hbWUiOiJGdW5jVXNlcjAxIiwiZW1haWwiOiJhc2hpc2guc2hhcm1hNDRAZ2UuY29tIiwiYXV0aF90aW1lIjoxNTIyMjE2Nzc3LCJyZXZfc2lnIjoiMjczNDYyZmUiLCJpYXQiOjE1MjIyMTY3NzcsImV4cCI6MTUyMjMwMzE3NywiaXNzIjoiaHR0cHM6Ly9mNmQwNTI0ZC0yOGQxLTRhZjgtYTIxYy0zYzc3OTc5MGFmZjQucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJmNmQwNTI0ZC0yOGQxLTRhZjgtYTIxYy0zYzc3OTc5MGFmZjQiLCJhdWQiOlsicGFzc3dvcmQiLCJpbmdlc3Rvci4yNmIzMDVlYy1mODAxLTRlNzYtYjAzYS1lZjQwOTQwMzU0NmUuMzU5YTgyZjYtNTAwYS00ZjI3LWI2M2EtNmFkZmMxZTgxOWYxIiwib3BlbmlkIl19.tX4RKjIXMrY2Nzst-DQEvgcEAAO_49Fw_4ZwfwXWvinYxt5gfjRi7xEsDLXQvykUrSFAEgkrEGZSVDs3wTtWO5zV4IvHFAvEhPTUJO-u0Uf8E_dPak0IJH_J37DEEqplTXWZw-jxzUyHOob6LNpLc_sxx2nJtniGgUtD2gXDY2IvMuokpX7xJHlGMZ99dVVZAuwSSeyCdNTZgZy8emchuPgTHmAjGWfM-pJ1wFzAXRe2GGwweqUzV0sZW6aTVjFa8HOE81TNE2o35JMbKrN2bXTlom7PuHKNVH7a9LA9p4YNAiyD3XY0FUGfEkmCrkUCnouyNPchTIsUSldYzqnpxA"); //$NON-NLS-1$
		// tenant NEED TO BE UPDATED
		header.put("tenant", "8b1a3e7d-ef80-4c6d-8182-5d406559d104"); //$NON-NLS-1$ //$NON-NLS-2$
		return header;
	}

	private List<String> getTagList(String url, String payload, HashMap<String, String> headers) {
		List<String> finalList = new ArrayList<>();
		try {
			String resp = new InClauseTS().executeQuery(url, payload, headers);
			JSONObject result = new JSONObject(resp);
			if (!result.has("data")) { //$NON-NLS-1$
				System.out.println("-------------------First Query Execution got failed-------------------- " + resp); //$NON-NLS-1$
				throw new Exception("Getting tagList Query failed"); //$NON-NLS-1$
			}
			JSONArray list = (JSONArray) result.get("data"); //$NON-NLS-1$
			System.out.println("------------response after first query execution--------->" + list.toString()); //$NON-NLS-1$
			/**
			 * Make tag list from Query response and store it in finalList
			 */
			for (int i = 0; i < list.length(); i++) {
				JSONArray smallarray = (JSONArray) list.get(i);
				finalList.add(smallarray.get(0).toString());
			}
			System.out.println("------final tag list ------------" + finalList.toString()); //$NON-NLS-1$
		} catch (Exception e) {
			System.out.println("------Error executing first Query ---------------" + e); //$NON-NLS-1$
			e.printStackTrace();
		}
		return finalList;
	}

	private HashMap<String, Double> getTotalSumAndAverage(String secondQueryres, int colIndex) {
		JSONObject avgJsonObject = new JSONObject(secondQueryres);
		JSONArray dataArray = avgJsonObject.getJSONArray("data"); //$NON-NLS-1$

		int totalNumberOfSums = dataArray.length();

		double sum = 0;
		for (int i = 0; i < dataArray.length(); i++) {
			double dailySum = 0;
			Object dailysumobject = dataArray.getJSONArray(i).get(colIndex);

			String dailySumString = dailysumobject.toString();
			if (dailySumString.equals("null") || dailySumString == "") { //$NON-NLS-1$ //$NON-NLS-2$
				dailySum = 0;
			} else {
				dailySum = Double.parseDouble(dailySumString);
			}
			sum += dailySum;

		}
		System.out.println("SUM IS    " + sum); //$NON-NLS-1$

		double average = sum / totalNumberOfSums;
		HashMap<String, Double> resultMap = new HashMap<>();
		resultMap.put("SUM", sum); //$NON-NLS-1$
		resultMap.put("AVG", average); //$NON-NLS-1$
		return resultMap;
	}

	private Connection getSqliteConn() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC"); //$NON-NLS-1$
			c = DriverManager.getConnection("jdbc:sqlite:test.db"); //$NON-NLS-1$
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()); //$NON-NLS-1$
			return null;
		}
		return c;
	}

	private void executeDeleteInsertQuery(Statement stmt, String sqlCommand) {
		System.out.println("Executing Query ---" + sqlCommand); //$NON-NLS-1$
		try {
			stmt.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Done Executing Query ---" + sqlCommand); //$NON-NLS-1$

	}

}