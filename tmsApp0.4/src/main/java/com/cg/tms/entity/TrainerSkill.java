package com.cg.tms.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_skill")
public class TrainerSkill implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TR_SKILL")
	@SequenceGenerator(sequenceName = "seq_tr_skill", allocationSize = 1, name = "SEQ_TR_SKILL")
	@Column(name = "id")
	private int id;

	@Column(name = "employeeid")
	private String employee;
	@OneToMany
	@JoinColumn(name = "skillid")
	private Set<Skill> skills;

	public TrainerSkill() {
	}

}