package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SKILL")
	@SequenceGenerator(sequenceName = "seq_skill", allocationSize = 1, name = "SEQ_SKILL")

	private int skillId;
	@Column(name = "skill_desc")
	private String skilldesc;

	public Skill() {
	}

	public Skill(int skillId, String skilldesc) {
		this.skillId = skillId;
		this.skilldesc = skilldesc;
	}

}
