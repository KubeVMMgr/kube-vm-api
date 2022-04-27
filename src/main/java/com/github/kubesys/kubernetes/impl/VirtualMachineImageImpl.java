/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineImageImpl extends AbstractImpl<VirtualMachineImage, VirtualMachineImageList, VirtualMachineImageSpec> {

	@Override
	public VirtualMachineImage getModel() {
		return new VirtualMachineImage();
	}

	@Override
	public VirtualMachineImageSpec getSpec() {
		return new VirtualMachineImageSpec();
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	@Override
	public VirtualMachineImageSpec getSpec(VirtualMachineImage r) {
		return r.getSpec();
	}

	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/

	public boolean createImage(String name, CreateImage createImage) throws Exception {
		return createImage(name, null, createImage, null);
	}

	public boolean createImage(String name, String nodeName, CreateImage createImage) throws Exception {
		return createImage(name, nodeName, createImage, null);
	}

	public boolean createImage(String name, CreateImage createImage, String eventId) throws Exception {
		return createImage(name, null, createImage, eventId);
	}

	public boolean createImage(String name, String nodeName,CreateImage createImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createImage)));
	}

	public boolean deleteImage(String name, DeleteImage deleteImage) throws Exception {
		return deleteImage(name, deleteImage, null);
	}

	public boolean deleteImage(String name, DeleteImage deleteImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteImage);
	}

	public boolean deleteImage(String name, String nodeName, DeleteImage deleteImage) throws Exception {
		updateHost(name, nodeName);
		return deleteImage(name, deleteImage, null);
	}

	public boolean deleteImage(String name, String nodeName, DeleteImage deleteImage, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteImage(name, deleteImage, eventId);
	}

	public boolean convertImageToVM(String name, ConvertImageToVM convertImageToVM) throws Exception {
		return convertImageToVM(name, convertImageToVM, null);
	}

	public boolean convertImageToVM(String name, ConvertImageToVM convertImageToVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), convertImageToVM);
	}

	public boolean convertImageToVM(String name, String nodeName, ConvertImageToVM convertImageToVM) throws Exception {
		updateHost(name, nodeName);
		return convertImageToVM(name, convertImageToVM, null);
	}

	public boolean convertImageToVM(String name, String nodeName, ConvertImageToVM convertImageToVM, String eventId) throws Exception {
		updateHost(name, nodeName);
		return convertImageToVM(name, convertImageToVM, eventId);
	}

}
