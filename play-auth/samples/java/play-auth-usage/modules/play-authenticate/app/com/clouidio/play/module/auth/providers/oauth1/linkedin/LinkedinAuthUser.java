package com.clouidio.play.module.auth.providers.oauth1.linkedin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;

import com.clouidio.play.module.auth.providers.oauth1.BasicOAuth1AuthUser;
import com.clouidio.play.module.auth.providers.oauth1.OAuth1AuthInfo;
import com.clouidio.play.module.auth.user.BasicIdentity;
import com.clouidio.play.module.auth.user.EducationIdentity;
import com.clouidio.play.module.auth.user.EmploymentIdentity;
import com.clouidio.play.module.auth.user.FirstLastNameIdentity;
import com.clouidio.play.module.auth.user.PicturedIdentity;

public class LinkedinAuthUser extends BasicOAuth1AuthUser implements
		BasicIdentity, FirstLastNameIdentity, PicturedIdentity,
		EmploymentIdentity, EducationIdentity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static abstract class Constants {

		public static final String ID = "id";
		public static final String PROFILE_IMAGE_URL = "pictureUrl";
		public static final String FIRST_NAME = "firstName";
		public static final String LAST_NAME = "lastName";
		public static final String INDUSTRY = "industry";
		public static final String POSITIONS = "positions/values";
		public static final String EDUCATIONS = "educations/values";

		private static abstract class Education {
			public static final String ID = "id";
			public static final String SCHOOL_NAME = "schoolName";
			public static final String DEGREE = "degree";
			public static final String START_DATE_YEAR = "startDate/year";
			public static final String END_DATE_YEAR = "endDate/year";
		}

		private static abstract class Employment {
			public static final String ID = "id";
			public static final String TITLE = "title";
			public static final String SUMMARY = "summary";
			public static final String START_DATE_MONTH = "startDate/month";
			public static final String START_DATE_YEAR = "startDate/year";
			public static final String END_DATE_MONTH = "endDate/month";
			public static final String END_DATE_YEAR = "endDate/year";
			public static final String IS_CURRENT = "isCurrent";
			public static final String COMPANY_NAME = "company/name";
		}

	}

	private String picture;
	private String firstName;
	private String lastName;
	private String industry;
	private String email;
	private List<EmploymentInfo> employments;
	private List<EducationInfo> educations;

	public LinkedinAuthUser(final JsonNode nodeInfo, final String email,
			final OAuth1AuthInfo info) {
		super(nodeInfo.get(Constants.ID).asText(), info, null);

		if (nodeInfo.has(Constants.FIRST_NAME)) {
			this.firstName = nodeInfo.get(Constants.FIRST_NAME).asText();
		}
		if (nodeInfo.has(Constants.LAST_NAME)) {
			this.lastName = nodeInfo.get(Constants.LAST_NAME).asText();
		}
		if (nodeInfo.has(Constants.PROFILE_IMAGE_URL)) {
			this.picture = nodeInfo.get(Constants.PROFILE_IMAGE_URL).asText();
		}
		if (nodeInfo.has(Constants.INDUSTRY)) {
			this.industry = nodeInfo.get(Constants.INDUSTRY).asText();
		}
		JsonNode node;
		if ((node = traverse(nodeInfo, Constants.POSITIONS)) != null) {
			this.employments = new ArrayList<EmploymentInfo>();
			Iterator<JsonNode> jn = node.getElements();
			while (jn.hasNext()) {
				JsonNode j = jn.next();
				this.employments.add(makeEmployment(j));
			}
		}
		if ((node = traverse(nodeInfo, Constants.EDUCATIONS)) != null) {
			this.educations = new ArrayList<EducationInfo>();
			Iterator<JsonNode> jn = node.getElements();
			while (jn.hasNext()) {
				JsonNode j = jn.next();
				this.educations.add(makeEducation(j));
			}
		}
		if (!StringUtils.isBlank(email)) {
			this.email = email;
		}
	}

	private static EducationInfo makeEducation(JsonNode node) {
		String id = null, schoolName = null, degree = null;
		int startDateYear = 0, endDateYear = 0;
		if (node.has(Constants.Education.ID)) {
			id = node.get(Constants.ID).asText();
		}
		if (node.has(Constants.Education.SCHOOL_NAME)) {
			schoolName = node.get(Constants.Education.SCHOOL_NAME).asText();
		}
		if (node.has(Constants.Education.DEGREE)) {
			degree = node.get(Constants.Education.DEGREE).asText();
		}
		JsonNode childNode;
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Education.START_DATE_YEAR)) != null) {
			startDateYear = childNode.asInt();
		}
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Education.END_DATE_YEAR)) != null) {
			endDateYear = childNode.asInt();
		}
		return new EducationInfo(id, schoolName, degree, startDateYear,
				endDateYear);
	}

	private static EmploymentInfo makeEmployment(JsonNode node) {
		String id = null, title = null, summary = null, companyName = null;
		int startDateMonth = 0, startDateYear = 0, endDateMonth = 0, endDateYear = 0;
		boolean isCurrent = false;
		if (node.has(Constants.Employment.ID)) {
			id = node.get(Constants.Employment.ID).asText();
		}
		if (node.has(Constants.Employment.TITLE)) {
			title = node.get(Constants.Employment.TITLE).asText();
		}
		if (node.has(Constants.Employment.SUMMARY)) {
			summary = node.get(Constants.Employment.SUMMARY).asText();
		}
		JsonNode childNode;
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Employment.START_DATE_MONTH)) != null) {
			startDateMonth = childNode.asInt();
		}
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Employment.START_DATE_YEAR)) != null) {
			startDateYear = childNode.asInt();
		}
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Employment.END_DATE_MONTH)) != null) {
			endDateMonth = childNode.asInt();
		}
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Employment.END_DATE_YEAR)) != null) {
			endDateYear = childNode.asInt();
		}
		if (node.has(Constants.Employment.IS_CURRENT)) {
			isCurrent = node.get(Constants.Employment.IS_CURRENT).asBoolean();
		}
		if ((childNode = LinkedinAuthUser.traverse(node,
				Constants.Employment.COMPANY_NAME)) != null) {
			companyName = childNode.asText();
		}
		return new EmploymentInfo(id, title, summary, startDateMonth,
				startDateYear, endDateMonth, endDateYear, isCurrent,
				companyName);
	}

	/**
	 * Gets the child node from a top node, by going going down the json tree
	 * via consuming '/'s.
	 * 
	 * @param topNode
	 * @return
	 */
	private static JsonNode traverse(JsonNode topNode, String childExpression) {
		JsonNode jsonNode = topNode;
		String[] segments = childExpression.split("/");
		for (String segment : segments) {
			if (jsonNode != null) {
				jsonNode = jsonNode.get(segment);
			} else {
				return null;
			}
		}
		return jsonNode;
	}

	@Override
	public String getProvider() {
		return LinkedinAuthProvider.PROVIDER_KEY;
	}

	@Override
	public String getName() {
		return firstName + " " + lastName;
	}

	@Override
	public String getPicture() {
		return picture;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	public String getIndustry() {
		return industry;
	}

	@Override
	public Collection<EmploymentInfo> getEmployment() {
		return employments;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Collection<EducationInfo> getEducation() {
		return educations;
	}

}
