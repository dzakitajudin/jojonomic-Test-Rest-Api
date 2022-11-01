package com.jojonomic.Emas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="tbl_harga", schema="public")
public class Emas {

	@Column(name="admin_id")
	private String AdminId;
	
	@Column(name="harga_topup_emas")
	private long HargaTopupEmas;
	
	@Column(name="harga_buyback_emas")
	private long HargaBuybackEmas;
	
	
}
